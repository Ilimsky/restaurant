package com.example.restaurant.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.restaurant.entities.Review}
 */
@Value
public class ReviewDto implements Serializable {
    int rating;
    String comment;
}