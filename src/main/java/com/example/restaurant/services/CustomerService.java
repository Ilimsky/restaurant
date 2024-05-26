package com.example.restaurant.services;

import java.util.List;

import com.example.restaurant.entities.Orders;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.OrderItemsDto;
import com.example.restaurant.dtos.RestaurantDto;
import com.example.restaurant.dtos.UserAddressDto;
import com.example.restaurant.dtos.ViewOrdersDto;

public interface CustomerService {

	public Orders placeOrder(List<OrderItemsDto> orderItemsList, String contactNumber,Integer restaurantId) throws UserServiceException;

	public List<ViewOrdersDto> viewOrder(String contactNumber) throws UserServiceException;

	public List<RestaurantDto> viewNearbyRestaurant(String contactNumber, String area) throws UserServiceException;

	public List<UserAddressDto> viewAllAddresses(String contactNumber) throws UserServiceException;

	public String addNewAddress(UserAddressDto addressDto, String contactNumber) throws UserServiceException;

	public String updateAddress(UserAddressDto addressDto, String contactNumber) throws UserServiceException;

	public String deleteAddress(UserAddressDto addressDto, String contactNumber) throws UserServiceException;

}
