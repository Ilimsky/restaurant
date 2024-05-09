package com.example.restaurant.repository;

import com.example.restaurant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}