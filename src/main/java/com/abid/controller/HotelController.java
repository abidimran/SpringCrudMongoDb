package com.abid.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abid.model.Hotel;
import com.abid.model.HotelDetail;
import com.abid.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	private HotelServiceImpl hotelService;
	
	public HotelController(HotelServiceImpl hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping("/ping")
	public ResponseEntity<String> Ping() {

		System.out.println("Coming for Hotel Ping");
		return ResponseEntity.status(HttpStatus.OK).body("Hotel OK");
	}

	@GetMapping("/all-hotels")
	public ResponseEntity<?> getAllHotelDetails(){

		List<Hotel> hotels = hotelService.getAllHotelDetails();
		if(hotels.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("No Hotel Details Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<?> getHotel(@PathVariable("hotelId") Integer hotelId){
		try {
			Hotel hotel =hotelService.getHotelDetails(hotelId);
			return ResponseEntity.status(HttpStatus.OK).body(hotel);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Hotel Detail Found");
		}
	}

	@PostMapping("/hotel")
	public ResponseEntity<Hotel> creatingHotel(@RequestBody Hotel hotel){
		System.out.println("HotelName: "+hotel.getName()+ 
				" HotelPrice: "+hotel.getPrice()+
				" HotelLocation: "+hotel.getLocation());
		Hotel food = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(food);
	}

	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable("hotelId") Integer hotelId){
		try {
			hotelService.deleteHotel(hotelId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Hotel Detail Found");
		}
	}

	
	@GetMapping("/hotel-detail/{hotelId}")
	public ResponseEntity<?> getHotelDetail(@PathVariable("hotelId") Integer hotelId){
		try {
			HotelDetail hotelDetail =hotelService.getHotelAllDetails(hotelId);
			return ResponseEntity.status(HttpStatus.OK).body(hotelDetail);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Hotel Detail Found");
		}
	}




}
