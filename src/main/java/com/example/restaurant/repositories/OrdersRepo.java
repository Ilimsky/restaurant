package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Orders;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {

}
