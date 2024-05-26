package com.example.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTransactionDto {
    private Integer restaurantTransactionId;
    private Integer restaurantOrderCounter;
    private Integer restaurantApproxCost;
    private Boolean restaurantStatus;
}
