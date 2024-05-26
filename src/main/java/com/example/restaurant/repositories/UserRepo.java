package com.example.restaurant.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.restaurant.entities.Users;

public interface UserRepo extends CrudRepository<Users,Integer>{

	public Optional<Users> findByContactNumber(String contactNumber);
}
