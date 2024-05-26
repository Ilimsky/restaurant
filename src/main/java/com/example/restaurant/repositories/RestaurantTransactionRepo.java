package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.RestaurantTransaction;

public interface RestaurantTransactionRepo extends CrudRepository<RestaurantTransaction,Integer>{

	public void deleteByRestaurantTransactionId(Integer restaurantTransactionId);
}
