package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="dish_rating")
public class DishRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dishRatingId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id", unique = true)
    private Dish dish;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", unique = true)
    private Users user;
    private Integer rating;

}
