package com.example.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
//@Table(name="coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponId;
	private String couponCode;
	private Integer minimumBill;
	private Integer maximumRedemption;
	private Date startDate;
	private Date endDate;
}
