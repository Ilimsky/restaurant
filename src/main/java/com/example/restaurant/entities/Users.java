package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Roles> roles;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Restaurant> restaurants;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<UserAddress> addressList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)
	private Wallet wallet;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<UserLikes> userLikesList;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Orders> ordersList;
}
