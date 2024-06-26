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
import com.numetry.Travel.and.Tourism.Management.System.Dto.TourPackageBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.TourPackageBookingService;

@RestController
@CrossOrigin
@RequestMapping("/public/package/Bookings")
public class TourPackageBookingController{


      @Autowired
      private TourPackageBookingService tourPackageBookingService;

      @PostMapping("/{userId}/{tourPackageId}")
      public TourPackageBookingDto createTourPackageBooking(@PathVariable Integer userId,
      
       @PathVariable Long tourPackageId, @RequestParam Integer distance,@RequestParam Integer bookForDays ){
            return tourPackageBookingService.createTourBooking(userId, tourPackageId, distance, bookForDays);
       }


       @DeleteMapping("/{id}")
       public String deleteTourPackageBooking(@PathVariable String id){

           return tourPackageBookingService.deleteBookings(id);
       }

       @GetMapping
       public List<TourPackageBookingDto> getAllTourPackageBookings(){
            
             return tourPackageBookingService.getAllTourPackageBookings();
       }

}