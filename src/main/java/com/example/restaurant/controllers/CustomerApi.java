package com.example.restaurant.controllers;

import java.util.List;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.entities.Orders;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.OrderItemsDto;
import com.example.restaurant.dtos.RestaurantDto;
import com.example.restaurant.dtos.UserAddressDto;
import com.example.restaurant.dtos.ViewOrdersDto;
import com.example.restaurant.services.CustomerServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value="customerAPI")
@Validated
public class CustomerApi {

	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping(value="/placeOrder/{contactNumber}/{restaurantId}")
	public ResponseEntity<Orders> placeOrder(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}")
			String contactNumber,
			@NotNull
			@PathVariable(value="restaurantId")
			Integer restaurantId,
			@RequestBody List<OrderItemsDto> orderItemsList) throws UserServiceException
	{
		Orders orders = customerService.placeOrder(orderItemsList, contactNumber,restaurantId);
		return new ResponseEntity(orders,HttpStatus.OK);
	}
	
	@GetMapping(value="/viewOrder/{contactNumber}")
	public ResponseEntity<ViewOrdersDto> viewOrder(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}") 
			String contactNumber) throws UserServiceException
	{
		List<ViewOrdersDto> viewOrdersDto = customerService.viewOrder(contactNumber);
		return new ResponseEntity(viewOrdersDto,HttpStatus.OK);
	}
	
	@GetMapping(value="/viewNearbyRestaurant/{contactNumber}/{area}")
	public ResponseEntity<List<RestaurantDto>> viewNearbyRestaurant(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}") 
			String contactNumber,
			@PathVariable(value="area")
			String area) throws UserServiceException
	{
		List<RestaurantDto> rest = customerService.viewNearbyRestaurant(contactNumber, area);
		return new ResponseEntity(rest,HttpStatus.OK);
	}
	@GetMapping(value="/viewAllAddresses/{contactNumber}")
	public ResponseEntity<List<UserAddressDto>> viewAllAddresses(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}") 
			String contactNumber) throws UserServiceException
	{
		List<UserAddressDto> list = customerService.viewAllAddresses(contactNumber);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	@PostMapping(value="/addNewAddress/{contactNumber}")
	public ResponseEntity<String> addNewAddress(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}")
			String contactNumber,
			@RequestBody
			@Valid
			UserAddressDto addressDto) throws UserServiceException
	{
		String success = customerService.addNewAddress(addressDto, contactNumber);
		return new ResponseEntity(success,HttpStatus.CREATED);
	}
	
	@PostMapping(value="/updateAddress/{contactNumber}")
	public ResponseEntity<String> updateAddress(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}")
			String contactNumber,
			@RequestBody
			@Valid
			UserAddressDto addressDto) throws UserServiceException
	{
		String success = customerService.updateAddress(addressDto, contactNumber);
		return new ResponseEntity(success,HttpStatus.CREATED);
	}
	@PostMapping(value="/deleteAddress/{contactNumber}")
	public ResponseEntity<String> deleteAddress(
			@PathVariable(value="contactNumber")
			@Pattern(regexp="[6789][0-9]{9}",message="{UserValidator.INVALID_CONTACT_NUMBER_FORMAT}")
			String contactNumber,
			@RequestBody
			@Valid
			UserAddressDto addressDto) throws UserServiceException
	{
		String success = customerService.deleteAddress(addressDto, contactNumber);
		return new ResponseEntity(success,HttpStatus.CREATED);
	}
}
