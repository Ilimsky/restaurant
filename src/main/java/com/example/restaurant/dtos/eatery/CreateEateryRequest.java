package com.example.restaurant.dtos.eatery;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateEateryRequest {
    @NotNull
    private String name;

    @NotNull
    private String description;
}
