package com.example.restaurant.configs;

import com.example.restaurant.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private final User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Arrays.stream(...): Преобразует массив строк в поток (stream) строк
        return Arrays.stream(user.getRoles().split(", ")) // 1. разбивает строку ролей пользователя на массив строк, используя запятую и пробел в качестве разделителя. Например, если user.getRoles() возвращает строку "ROLE_USER, ROLE_ADMIN", то этот метод вернет массив ["ROLE_USER", "ROLE_ADMIN"].
                .map(SimpleGrantedAuthority::new) // 2. Для каждой строки в потоке создается объект SimpleGrantedAuthority. Этот объект используется для представления роли пользователя в Spring Security. Каждая роль обычно начинается с "ROLE_" (например, "ROLE_USER").
                .collect(Collectors.toList()); // 3. Преобразует поток объектов SimpleGrantedAuthority в список
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}