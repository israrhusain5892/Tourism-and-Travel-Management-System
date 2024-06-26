package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.BusBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.BusBookingService;

@RestController
@CrossOrigin
@RequestMapping("/public/busBooking")
public class BusBookingController {
    
       @Autowired
       private BusBookingService bookingService;

       @PostMapping("/{email}/{busId}/{routeId}")
       public BusBookingDto createBusBooking(@PathVariable String email, @PathVariable Long busId
       , @PathVariable Long routeId
       ){
              
                return bookingService.createBusBooking(email, busId,routeId);
       }

       @GetMapping
       public List<BusBookingDto> getAllBookings(){
              return bookingService.getAllBookings();
       }

       @DeleteMapping("/{id}")
       public String deleteBusBooking(@PathVariable Long id){
              return bookingService.deleteBusBooking(id);
       }

}
