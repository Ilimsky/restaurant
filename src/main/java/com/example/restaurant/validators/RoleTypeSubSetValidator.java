package com.example.restaurant.validators;

import java.util.Arrays;


import com.example.restaurant.dtos.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleTypeSubSetValidator implements ConstraintValidator<RoleTypeSubset, Role> {
    private Role[] subset;

    @Override
    public void initialize(RoleTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Role value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}