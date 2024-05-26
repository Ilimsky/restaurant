package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.OrderItems;

public interface OrderItemsRepo extends CrudRepository<OrderItems,Integer>{

	public void deleteByDish(Dish dish);
}
