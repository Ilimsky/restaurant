package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
//@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private Integer orderBill;
	private String orderStatus;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderItems> orderItemsList;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

}

