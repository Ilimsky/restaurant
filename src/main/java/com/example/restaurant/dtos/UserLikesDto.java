package com.example.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLikesDto {

    private Integer likeId;
    private String vegNonveg;
    private DishDto dish;
    private RestaurantDto restaurant;

}
