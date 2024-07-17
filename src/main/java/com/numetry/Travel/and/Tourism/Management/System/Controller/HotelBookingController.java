
package com.numetry.Travel.and.Tourism.Management.System.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.HotelBookingService;


@RestController
@RequestMapping("/public/bookings")
@CrossOrigin
public class HotelBookingController {
	 @Autowired
	    private HotelBookingService bookingService;

	    @GetMapping
	    public List<HotelBookingDto> getAllBookings() {
	        return bookingService.getAllBookings();
	    }

	    @GetMapping("/{id}")
	    public HotelBookingDto getBookingById(@PathVariable Long id) {
	        return bookingService.getBookingById(id);
	    }

	    @PostMapping("/{email}/{hotelId}")
	    public HotelBookingDto addBooking(@PathVariable String email, @PathVariable Long hotelId,@RequestParam int bookForDays) {
	        return bookingService.addBooking(email,hotelId,bookForDays);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBooking(@PathVariable Long id) {
	        bookingService.deleteBooking(id);
	    }
	}
