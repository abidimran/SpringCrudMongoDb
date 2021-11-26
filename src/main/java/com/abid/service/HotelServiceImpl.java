package com.abid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abid.model.Hotel;
import com.abid.model.HotelDetail;
import com.abid.repository.HotelRepository;


@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;


	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> getAllHotelDetails() {

		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelDetails(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {

		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotel(Integer hotelId) {

		hotelRepository.deleteById(hotelId);

	}

	@Override
	public HotelDetail getHotelAllDetails(Integer hotelId) {

		Optional<Hotel> hotel = hotelRepository.findById(hotelId);

		if(hotel.isPresent()) {
			Hotel hotelOptional = hotel.get();
			HotelDetail detail = HotelDetail.builder().hotelDetailId(hotelOptional.getId())
					.hoteLlocation(hotelOptional.getLocation())
					.hotelName(hotelOptional.getName())
					.hotePrice(hotelOptional.getPrice())
					.booking(hotelOptional.getBooking())
					.build();
			return detail;
		}
		return null;

	}

}
