package com.example.restaurant.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotEmpty(message = "Поле не должно быть пустым")
    private String username;

    @NotEmpty
    @Email(message = "Обязательное поле")
    private String email;

    @Size(min = 6, max = 12, message = "Длина пароля должна быть от 6 до 12 символов")
    private String password;
}
