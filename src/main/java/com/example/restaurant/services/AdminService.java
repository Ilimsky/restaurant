package com.example.restaurant.services;

import java.util.List;

import com.example.restaurant.exceptions.AdminServiceException;
import com.example.restaurant.exceptions.RestaurantNotFoundException;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.RestaurantDto;

public interface AdminService {
	public List<RestaurantDto> viewAllRegistrationRequests(String contactNumber)
			throws RestaurantNotFoundException, UserServiceException;

	public String accepctRegistrationRequest(RestaurantDto restaurantDto, String contactNumber)
			throws UserServiceException, RestaurantNotFoundException, AdminServiceException;

	public String rejectRegistrationRequest(RestaurantDto restaurantDto, String contactNumber)
			throws UserServiceException, RestaurantNotFoundException, AdminServiceException;

	public List<RestaurantDto> viewLowRatingRestaurants(String contactNumber)
			throws RestaurantNotFoundException, UserServiceException, AdminServiceException;

	public String deleteLowRatingRestaurant(RestaurantDto restaurantDto, String contactNumber)
			throws UserServiceException, AdminServiceException;

}
