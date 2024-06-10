package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelRepository;


@Service
public class HotelService {
	
	   @Autowired
	    private HotelRepository hotelRepository;

	    public List<Hotel> getAllHotels() {
	        return hotelRepository.findAll();
	    }

	    public java.util.Optional<Hotel> getHotelById(Long id) {
	        return hotelRepository.findById(id);
	    }

	    public Hotel addHotel(Hotel hotel) {
	        return hotelRepository.save(hotel);
	    }

	    public void deleteHotel(Long id) {
	        hotelRepository.deleteById(id);
	    }
	}
