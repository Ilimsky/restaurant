package com.example.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemsDto {
	private Integer orderItemsId;
	private DishDto dish;
	private Integer qty;
}
