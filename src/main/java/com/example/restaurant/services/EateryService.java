package com.example.restaurant.services;

import com.example.restaurant.dtos.Pagination;
import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.dtos.eatery.CreateEateryRequest;
import com.example.restaurant.dtos.eatery.UpdateEateryRequest;

public interface EateryService {
    EateryDTO createEatery(CreateEateryRequest createEateryRequest);

    Pagination<EateryDTO> getAllEateries(int pageNo, int pageSize);

    EateryDTO getEateryDtoById(Long id);

    Long deleteEateryById(Long id);

    EateryDTO updateEatery(UpdateEateryRequest updateEateryRequest, Long id);

}