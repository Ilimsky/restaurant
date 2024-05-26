package com.example.restaurant.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Restaurant;

public interface RestaurantRepo extends CrudRepository<Restaurant,Integer>{

	
	public List<Restaurant> getAllRestaurantByArea(String area);

}
