package com.abid.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abid.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, Integer> {

}
