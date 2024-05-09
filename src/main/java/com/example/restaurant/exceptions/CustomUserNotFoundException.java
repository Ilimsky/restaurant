package com.example.restaurant.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserNotFoundException extends UsernameNotFoundException {
    public CustomUserNotFoundException(String msg) {
        super(msg);
    }

    public CustomUserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
