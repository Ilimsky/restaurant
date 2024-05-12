package com.example.restaurant.entities;

import com.example.restaurant.dtos.PhotoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Eatery eatery;

    public Photo(PhotoDTO photoDto) {
        this.url = photoDto.getUrl();
    }
}
