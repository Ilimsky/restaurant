package com.example.restaurant.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.restaurant.entities.Photo}
 */
@Value
public class PhotoDTO implements Serializable {
    String url;
}