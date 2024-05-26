package com.example.restaurant.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name="table_booking")
public class TableBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Date bookingDate;
	private LocalDateTime timeOfBooking;
	private Integer noOfPeople;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)
	private Users user;

}
