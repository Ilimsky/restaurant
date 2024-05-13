package com.example.restaurant.dtos.eatery;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UpdateEateryRequest {
    @NotNull
    private String name;

    @NotNull
    private String description;
}
