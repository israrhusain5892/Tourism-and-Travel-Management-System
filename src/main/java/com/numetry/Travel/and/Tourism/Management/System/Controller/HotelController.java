package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Service.HotelService;



@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	    @Autowired
	    private HotelService hotelService;

	    @GetMapping
	    public List<Hotel> getAllHotels() {
	        return hotelService.getAllHotels();
	    }

	    @GetMapping("/{id}")
	    public java.util.Optional<Hotel> getHotelById(@PathVariable Long id) {
	        return hotelService.getHotelById(id);
	    }

	    @PostMapping
	    public Hotel addHotel(@RequestBody Hotel hotel) {
	        return hotelService.addHotel(hotel);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteHotel(@PathVariable Long id) {
	        hotelService.deleteHotel(id);
	    }
	}

	