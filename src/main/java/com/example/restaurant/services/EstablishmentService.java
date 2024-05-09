package com.example.restaurant.services;

import com.example.restaurant.entities.Establishment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EstablishmentService {
    Establishment saveEstablishment(Establishment establishment);
    Page<Establishment> getAllEstablishments(Pageable pageable);
    Optional<Establishment> getOneByEstablishmentId(Long establishmentId);
    void deleteById(Long photoId);
}