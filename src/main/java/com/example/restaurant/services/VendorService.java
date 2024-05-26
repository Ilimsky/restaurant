package com.example.restaurant.services;

import java.util.List;

import com.example.restaurant.exceptions.RestaurantNotFoundException;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.exceptions.VendorServiceException;
import com.example.restaurant.dtos.DishDto;
import com.example.restaurant.dtos.RestaurantDto;

public interface VendorService {
	public String registerRestaurant(RestaurantDto restaurantDto, String contactNumber)
			throws UserServiceException, RestaurantNotFoundException, VendorServiceException;
	
	public List<RestaurantDto> viewRestaurantAndMenu(String contactNumber)
			throws UserServiceException,RestaurantNotFoundException;
	
	public String addDish(String contactNumber, Integer restaurantId, DishDto dishDto)
			throws UserServiceException, VendorServiceException; 
	
	public String updateDish(String contactNumber, Integer restaurantId, DishDto dishDto)
			throws UserServiceException, VendorServiceException;
	
	public String deleteDish(String contactNumber, Integer restaurantId, DishDto dishDto)
			throws UserServiceException, VendorServiceException ;

}
