package com.example.restaurant.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.restaurant.entities.Establishment}
 */
@Value
public class EstablishmentDTO implements Serializable {
    String name;
    String description;
}