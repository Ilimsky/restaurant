package com.example.restaurant.repository;

import com.example.restaurant.entities.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
}