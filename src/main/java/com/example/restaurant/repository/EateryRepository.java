package com.example.restaurant.repository;

import com.example.restaurant.entities.Eatery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EateryRepository extends JpaRepository<Eatery, Long> {
}