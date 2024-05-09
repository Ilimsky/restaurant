package com.example.restaurant.controllers;

import com.example.restaurant.dtos.UserDTO;
import com.example.restaurant.entities.User;
import com.example.restaurant.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/registration")
    public String registrationPage(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registration(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "registration";
        }
        try {
            userService.register(new User(userDTO));
        } catch (DataIntegrityViolationException e) {
            bindingResult.addError(new FieldError("userDto", "email", "Данная почта уже зарегистрирована"));
            return "registration";
        }
        return "redirect:/login";
    }
}