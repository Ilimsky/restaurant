package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="restaurant_transaction")
public class RestaurantTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantTransactionId;
	private Integer restaurantOrderCounter;
	private Integer restaurantApproxCost;
	private Boolean restaurantStatus;

	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;
}
