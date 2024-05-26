package com.example.restaurant.services;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Restaurant;
import com.example.restaurant.entities.Roles;
import com.example.restaurant.entities.Users;
import com.example.restaurant.exceptions.AdminServiceException;
import com.example.restaurant.exceptions.RestaurantNotFoundException;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.ApprovalStatus;
import com.example.restaurant.dtos.RestaurantDto;
import com.example.restaurant.dtos.Role;
import com.example.restaurant.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    DishRepo dishRepo;
    @Autowired
    OrdersRepo OrdersRepo;
    @Autowired
    RestaurantTransactionRepo restaurantTransactionRepo;
    @Autowired
    OrderItemsRepo orderItemsRepo;
    @Autowired
    TableBookingRepo tableBookingRepo;
    @Autowired
    SearchServiceImpl searchService;
    @Autowired
    Environment environment;

    @Override
    public List<RestaurantDto> viewAllRegistrationRequests(String contactNumber) throws RestaurantNotFoundException, UserServiceException {
        Optional<Users> op = userRepo.findByContactNumber(contactNumber);
        Users user = op.orElseThrow(() -> new UserServiceException("AdminService.NO_USER_FOUND"));

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Boolean flag = false;
        for (Roles role : user.getRoles()) {
            if (role.getRoleType().equals(Role.ADMIN)) {
                flag = true;
            }
        }
        if (flag == false) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        List<RestaurantDto> rest = searchService.getAllRestaurant();
        return rest;
    }

    @Override
    public String accepctRegistrationRequest(RestaurantDto restaurantDto, String contactNumber) throws UserServiceException, RestaurantNotFoundException, AdminServiceException {
        Optional<Users> op = userRepo.findByContactNumber(contactNumber);
        Users user = op.orElseThrow(() -> new UserServiceException("AdminService.NO_USER_FOUND"));

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Boolean flag = false;
        for (Roles role : user.getRoles()) {
            if (role.getRoleType().equals(Role.ADMIN)) {
                flag = true;
            }
        }
        if (flag == false) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Optional<Restaurant> opRest = restaurantRepo.findById(restaurantDto.getRestaurantId());
        Restaurant rest = opRest.orElseThrow(() -> new RestaurantNotFoundException("AdminService.RESTAURANT_NOT_FOUND"));

        if (rest.getApprovalStatus().equals(ApprovalStatus.Pending.toString())) {
            rest.setApprovalStatus(ApprovalStatus.Accepted.toString());
        } else {
            throw new AdminServiceException("AdminService.INVALID_STATUS");
        }
        return environment.getProperty("AdminService.REGISTRATION_ACCEPTED");
    }

    @Override
    public String rejectRegistrationRequest(RestaurantDto restaurantDto, String contactNumber) throws UserServiceException, RestaurantNotFoundException, AdminServiceException {
        Optional<Users> op = userRepo.findByContactNumber(contactNumber);
        Users user = op.orElseThrow(() -> new UserServiceException("AdminService.NO_USER_FOUND"));

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Boolean flag = false;
        for (Roles role : user.getRoles()) {
            if (role.getRoleType().equals(Role.ADMIN)) {
                flag = true;
            }
        }
        if (flag == false) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Optional<Restaurant> opRest = restaurantRepo.findById(restaurantDto.getRestaurantId());
        Restaurant rest = opRest.orElseThrow(() -> new RestaurantNotFoundException("AdminService.RESTAURANT_NOT_FOUND"));

        if (rest.getApprovalStatus().equals(ApprovalStatus.Pending.toString())) {
            rest.setApprovalStatus(ApprovalStatus.Rejected.toString());
        } else {
            throw new AdminServiceException("AdminService.INVALID_STATUS");
        }
        return environment.getProperty("AdminService.REGISTRATION_REJECTED");
    }

    @Override
    public List<RestaurantDto> viewLowRatingRestaurants(String contactNumber) throws RestaurantNotFoundException, UserServiceException, AdminServiceException {
        List<RestaurantDto> rest = this.viewAllRegistrationRequests(contactNumber);
        List<RestaurantDto> lowRatingRest;
        lowRatingRest = rest.stream().filter(x -> x.getAvgRating() < 1.5).collect(Collectors.toList());
        if (lowRatingRest.isEmpty()) {
            throw new AdminServiceException("AdminService.LOW_RATING_RESTAURANT_NOT_FOUND");
        }
        return lowRatingRest;
    }

    @Override
    public String deleteLowRatingRestaurant(RestaurantDto restaurantDto, String contactNumber) throws UserServiceException, AdminServiceException {
        Optional<Users> op = userRepo.findByContactNumber(contactNumber);
        Users user = op.orElseThrow(() -> new UserServiceException("AdminService.NO_USER_FOUND"));

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }
        Boolean flag = false;
        for (Roles role : user.getRoles()) {
            if (role.getRoleType().equals(Role.ADMIN)) {
                flag = true;
            }
        }
        if (flag == false) {
            throw new UserServiceException("AdminService.Invalid_USER_ROLE");
        }

        //get all users from db
        Iterable<Users> opAllUser = userRepo.findAll();
        List<Users> allUser = new ArrayList();
        opAllUser.forEach(u -> {
            allUser.add(u);
        });
        if (allUser.isEmpty()) {
            throw new UserServiceException("AdminService.NO_USER_FOUND");
        }
        List<Restaurant> newRest = new ArrayList();

        boolean found = false;
        for (Users u : allUser) {
            for (Restaurant r : u.getRestaurants()) {
                if (r.getRestaurantId().equals(restaurantDto.getRestaurantId())) {
                    if (r.getAvgRating() >= 1.5) {
                        throw new AdminServiceException("AdminService.RESTAURANT_NOT_LOW_RATED");
                    }

                    tableBookingRepo.deleteByRestaurant(r);
                    //delete all transactions
                    if (r.getTransaction() != null) {
                        restaurantTransactionRepo.deleteByRestaurantTransactionId(r.getTransaction().getRestaurantTransactionId());
                    }
                    if (r.getDishes() != null) {
                        //delete all order items for dishes
                        r.getDishes().stream().forEach(x -> {
                            orderItemsRepo.deleteByDish(x);
                        });
                        //delete all dishes
                        for (Dish d : r.getDishes()) {
                            dishRepo.deleteByDishId(d.getDishId());
                        }
                    }
                    found = true;
                } else {
                    newRest.add(r);
                }
            }
            u.setRestaurants(newRest);
        }
        if (found == false) {
            throw new AdminServiceException("AdminService.RESTAURANT_NOT_FOUND");
        }
        restaurantRepo.deleteById(restaurantDto.getRestaurantId());
        return environment.getProperty("AdminService.RESTAURANT_DELETED_SUCCESS");
    }

}
