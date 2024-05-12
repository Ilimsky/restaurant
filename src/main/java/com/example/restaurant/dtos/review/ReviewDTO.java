package com.example.restaurant.dtos.review;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.example.restaurant.entities.Review}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO implements Serializable {
    private Long id;
    private int rating;
    private String comment;
}