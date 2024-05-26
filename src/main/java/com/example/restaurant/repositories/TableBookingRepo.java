package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Restaurant;
import com.example.restaurant.entities.TableBooking;

public interface TableBookingRepo extends CrudRepository<TableBooking,Integer> {
	
	public void deleteByRestaurant(Restaurant restaurant);
}
