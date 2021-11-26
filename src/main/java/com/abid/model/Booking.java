package com.abid.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Booking {
	
	private Integer bookingId;
	private String  guestName;
	private Date bookingStartDate;
	private Date bookingendDate;

}
