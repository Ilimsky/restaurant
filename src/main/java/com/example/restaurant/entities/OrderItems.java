package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemsId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id", unique = true)
    private Dish dish;
    private Integer qty;

}
