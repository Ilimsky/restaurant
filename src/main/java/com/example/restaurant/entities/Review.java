package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Eatery eatery;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
