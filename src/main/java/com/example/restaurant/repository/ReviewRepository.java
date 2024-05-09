package com.example.restaurant.repository;

import com.example.restaurant.entities.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Long, Establishment> {
}