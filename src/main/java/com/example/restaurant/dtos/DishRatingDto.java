package com.example.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRatingDto {

	private Integer dishRatingId;
	private DishDto dish;
	private UsersDto user;
	private Integer rating;
	
}
