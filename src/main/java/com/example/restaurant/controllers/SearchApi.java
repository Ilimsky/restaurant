package com.example.restaurant.controllers;

import com.example.restaurant.exceptions.RestaurantNotFoundException;
import com.example.restaurant.dtos.RestaurantDto;
import com.example.restaurant.services.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("searchAPI")
public class SearchApi {

	@Autowired
	SearchServiceImpl search;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value="/getAllRestaurants")
	public ResponseEntity<List<RestaurantDto>> getAllRestaurants() throws RestaurantNotFoundException
	{
		List<RestaurantDto> res = search.getAllRestaurant();
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
}
