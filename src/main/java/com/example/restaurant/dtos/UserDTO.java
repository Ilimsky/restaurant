package com.example.restaurant.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.restaurant.entities.User}
 */
@Value
public class UserDTO implements Serializable {
    @NotEmpty
    String username;

    @Email
    @NotEmpty
    String email;

    @Size(min = 6)
    @NotEmpty
    String password;


}