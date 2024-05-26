package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
//@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantContact;
    private String restaurantType;
    private String addressLine1;
    private String area;
    private String city;
    private String resState;
    private Integer pincode;
    private String approvalStatus;

    private Double avgRating;
    private String photoUrls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private List<Dish> dishes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", unique = true)
    private RestaurantTransaction transaction;

}
