package com.example.restaurant.services;

import java.security.NoSuchAlgorithmException;

import com.example.restaurant.exceptions.InvalidCredentialsException;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.LoginCredentialsDto;
import com.example.restaurant.dtos.UserRegisterDto;
import com.example.restaurant.dtos.UsersDto;

public interface UserService {

	public String registerUser(UsersDto user) throws UserServiceException, NoSuchAlgorithmException;
	public UsersDto userLogin(LoginCredentialsDto login) throws InvalidCredentialsException, NoSuchAlgorithmException;
	public String registerUser(UserRegisterDto user) throws UserServiceException, NoSuchAlgorithmException;//new method
}
