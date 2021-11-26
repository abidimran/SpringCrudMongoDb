package com.abid.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class HotelDetail {
	
	private int hotelDetailId;
	private String hotelName;
	private String hoteLlocation;
	private Double hotePrice;
	private List<Booking> booking;
	
	

}
