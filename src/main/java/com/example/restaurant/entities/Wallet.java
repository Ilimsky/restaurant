package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name="wallet")
@Getter
@Setter
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;

	private Float availableAmount;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;
	
}