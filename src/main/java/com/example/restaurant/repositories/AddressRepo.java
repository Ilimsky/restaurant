package com.example.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.UserAddress;

public interface AddressRepo extends CrudRepository<UserAddress,Integer>{

}
