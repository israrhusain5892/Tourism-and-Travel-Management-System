
package com.numetry.Travel.and.Tourism.Management.System.Controller;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Model.Booking;
import com.numetry.Travel.and.Tourism.Management.System.Service.BookingService;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	 @Autowired
	    private BookingService bookingService;

	    @GetMapping
	    public List<Booking> getAllBookings() {
	        return bookingService.getAllBookings();
	    }

	    @GetMapping("/{id}")
	    public  java.util.Optional<Booking> getBookingById(@PathVariable Long id) {
	        return bookingService.getBookingById(id);
	    }

	    @PostMapping
	    public Booking addBooking(@RequestBody Booking booking) {
	        return bookingService.addBooking(booking);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBooking(@PathVariable Long id) {
	        bookingService.deleteBooking(id);
	    }
	}
