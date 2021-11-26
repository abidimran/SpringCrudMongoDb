package com.abid.service;

import java.util.List;

import com.abid.model.Hotel;
import com.abid.model.HotelDetail;


public interface HotelService {

	public List<Hotel> getAllHotelDetails();
	public Hotel getHotelDetails(Integer hotelId);
	public Hotel saveHotel(Hotel hotel);
	public void deleteHotel(Integer hotelId);
	public HotelDetail getHotelAllDetails(Integer hotelId);
	
	
}
