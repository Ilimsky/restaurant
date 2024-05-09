package com.example.restaurant.entities;

import com.example.restaurant.dtos.EstablishmentDTO;
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
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    public Establishment(EstablishmentDTO establishmentDto) {
        this.name = establishmentDto.getName();
        this.description = establishmentDto.getDescription();
    }
}
