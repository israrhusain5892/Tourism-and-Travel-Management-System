package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import com.numetry.Travel.and.Tourism.Management.System.Model.Trip;
import com.numetry.Travel.and.Tourism.Management.System.Model.TripBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TripBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TripRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;


@Service
public class TripBookingService {

     @Autowired
     private ModelMapper modelMapper;

     @Autowired
     private TripBookingRepository tripBookingRepository;

     @Autowired
     private UserRepository userRepository;

     @Autowired
     private TripRepository tripRepository;

     public TripBookingDto createTripBooking(Integer userId, UUID tripId) {

          User user = userRepository.findById(userId).get();

          Trip trip = tripRepository.findById(tripId).get();

          try {
               TripBooking tripBooking = new TripBooking();
               tripBooking.setBookingDate(new Date());
               tripBooking.setPaymentStatus("PENDING");
               tripBooking.setTripBookingStatus("BOOKED");
               tripBooking.setTripeBookingPrice(trip.getTripPrice());
               tripBooking.setUser(user);

               List<TripBooking> tripBookings = new ArrayList<>();
               tripBookings.add(tripBooking);
               trip.setTripBookings(tripBookings);

               List<TripBooking> tripBookings2 = new ArrayList<>();
               tripBookings2.add(tripBooking);
               trip.setTripBookings(tripBookings2);
               tripBooking.setTrip(trip);

               TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);
               TripBookingDto tripBookingDto = modelMapper.map(savedTripBooking, TripBookingDto.class);

               return tripBookingDto;

          } catch (Exception e) {
               e.printStackTrace();
          }
          return null;
     }

     public List<TripBookingDto> getAllBookings() {

          List<TripBookingDto> list = new ArrayList<>();

          List<TripBooking> tripBookings = tripBookingRepository.findAll();

          for (TripBooking tripBooking : tripBookings) {

               TripBookingDto tripBookingDto = modelMapper.map(tripBooking, TripBookingDto.class);
               String url = "";
               TripResponse res = tripBookingDto.getTrip();
               url = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path("/trip/download/")
                         .path(res.getTripId() + "")
                         .toUriString();
               res.setUrl(url);
               list.add(tripBookingDto);
          }
          return list;
     }

     public String deleteTripBooking(Long id) {
          
            tripBookingRepository.deleteById(id);
           return "tripBooking deleted successfully width id : "+id;
         
     }

}
