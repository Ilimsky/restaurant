package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="user_likes")
public class UserLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likeId;
    private String vegNonveg;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id", unique = true)
    private Dish dish;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", unique = true)
    private Restaurant restaurant;

}
