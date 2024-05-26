package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Dish;

public interface DishRepo extends CrudRepository<Dish,Integer> {

	public void deleteByDishId(Integer dishId);
}
