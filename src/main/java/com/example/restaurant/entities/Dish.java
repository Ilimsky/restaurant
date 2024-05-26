package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dishId;

    private String dishName;
    private String dishCuisine;
    private String dishType;
    private String dishDescription;
    private Double price;
    private Double avgRating;
    private String speciality;
    private String imageUrl;

}
