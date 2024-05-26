package com.example.restaurant.services;
import java.util.List;

import com.example.restaurant.dtos.RestaurantDto;


public interface SearchService {

	public List<RestaurantDto> getAllRestaurant() throws Exception;


}
