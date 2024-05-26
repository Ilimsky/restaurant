package com.example.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewOrdersDto {
    Integer orderId;
    List<OrderItemsDto> orderItems;
    String restaurantName;
    Integer totalPrice;

}
