package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.TripBookingService;

@RestController
@CrossOrigin
@RequestMapping("/public/tripBooking")
public class TripBookingController {

    @Autowired
    private TripBookingService tripBooking;

    @PostMapping("/{userId}/{tripId}")
    public TripBookingDto createBooking(@PathVariable Integer userId, @PathVariable UUID tripId) {
        return tripBooking.createTripBooking(userId, tripId);
    }

    @GetMapping
    public List<TripBookingDto> getAllBookings() {
        return tripBooking.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public String deleteTripBooking(@PathVariable Long id){
         return tripBooking.deleteTripBooking(id);
    }
}
