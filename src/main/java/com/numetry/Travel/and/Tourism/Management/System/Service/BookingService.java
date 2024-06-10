package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.Travel.and.Tourism.Management.System.Model.Booking;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BookingRepository;



@Service
public class BookingService {
	  @Autowired
	    private BookingRepository bookingRepository;

	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    public Optional<Booking> getBookingById(Long id) {
	        return bookingRepository.findById(id);
	    }

	    public Booking addBooking(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    public void deleteBooking(Long id) {
	        bookingRepository.deleteById(id);
	    }
	}


