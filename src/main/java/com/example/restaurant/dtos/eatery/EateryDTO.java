package com.example.restaurant.dtos.eatery;

import com.example.restaurant.entities.Eatery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Eatery}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EateryDTO {

    private String name;
    private String description;
}