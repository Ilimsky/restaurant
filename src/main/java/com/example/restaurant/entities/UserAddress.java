package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAddressId;
    private String userAddressName;
    private String addressLine1;
    private String addressLine2;
    private String area;
    private String city;
    private String userState;
    private String pincode;

}
