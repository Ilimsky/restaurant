package com.example.restaurant.dtos.review;

import com.example.restaurant.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDTO reviewToreviewDTO(Review review){
        return ReviewDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();
    }
}
