package com.example.restaurant.repository;

import com.example.restaurant.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Long, Review> {
}
