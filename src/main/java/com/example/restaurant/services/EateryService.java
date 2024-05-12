package com.example.restaurant.services;

import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.dtos.eatery.CreateEateryRequest;

public interface EateryService {
//    Eatery saveEstablishment(Eatery establishment);
//    Page<Eatery> getAllEstablishments(Pageable pageable);
//    Optional<Eatery> getOneByEstablishmentId(Long establishmentId);
//    void deleteById(Long photoId);


    EateryDTO createEatery(CreateEateryRequest createEateryRequest);
}