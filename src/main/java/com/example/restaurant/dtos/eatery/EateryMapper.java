package com.example.restaurant.dtos.eatery;

import com.example.restaurant.dtos.review.ReviewMapper;
import com.example.restaurant.entities.Eatery;
import org.springframework.stereotype.Component;

@Component
public class EateryMapper {

    private final ReviewMapper reviewMapper;

    public EateryMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public EateryDTO eateryToeateryDTO(Eatery eatery){
        return EateryDTO.builder()
                .name(eatery.getName())
                .description(eatery.getDescription())
                .build();
    }
}
