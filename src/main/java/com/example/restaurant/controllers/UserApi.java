package com.example.restaurant.controllers;

import com.example.restaurant.exceptions.InvalidCredentialsException;
import com.example.restaurant.exceptions.UserServiceException;
import com.example.restaurant.dtos.LoginCredentialsDto;
import com.example.restaurant.dtos.SuccessMessage;
import com.example.restaurant.dtos.UserRegisterDto;
import com.example.restaurant.dtos.UsersDto;
import com.example.restaurant.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping(value="userAPI")
public class UserApi {

	@Autowired
	Environment environment;
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping(value="/register")
	public ResponseEntity<SuccessMessage> registerUser(@Valid @RequestBody UsersDto user) throws UserServiceException, NoSuchAlgorithmException
	{
		System.out.println(user);
		String success = userService.registerUser(user);
		SuccessMessage s = new SuccessMessage();
		s.setMessage(success);
		return new ResponseEntity<SuccessMessage>(s,HttpStatus.OK);
	}
	
	@PostMapping(value="/userRegister")
	public ResponseEntity<SuccessMessage> newRegisterUser(@Valid @RequestBody UserRegisterDto userReg) throws UserServiceException, NoSuchAlgorithmException
	{
		System.out.println(userReg);
		String success = userService.registerUser(userReg);
		SuccessMessage s = new SuccessMessage();
		s.setMessage(success);
		return new ResponseEntity<SuccessMessage>(s,HttpStatus.OK);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<UsersDto> userLogin(@Valid @RequestBody LoginCredentialsDto login) throws NoSuchAlgorithmException, InvalidCredentialsException
	{
		UsersDto loggedinUser = userService.userLogin(login);
		return new ResponseEntity(loggedinUser,HttpStatus.OK);
	}
}
