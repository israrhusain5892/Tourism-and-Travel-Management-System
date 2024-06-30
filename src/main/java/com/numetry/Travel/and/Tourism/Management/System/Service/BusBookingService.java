package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.numetry.Travel.and.Tourism.Management.System.Dto.BusBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;

import com.numetry.Travel.and.Tourism.Management.System.Dto.RouteDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.SeatDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.Bus;
import com.numetry.Travel.and.Tourism.Management.System.Model.BusBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.Seat;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Model.Route;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BusBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BusRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.RouteRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.SeatRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.BusServiceImpl;

@Service
public class BusBookingService {

      @Autowired
      private BusBookingRepository busBookingRepository;

      @Autowired
      private ModelMapper modelMapper;

      @Autowired
      private BusRepository busRepository;

      @Autowired
      private RouteRepository routeRepository;

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private SeatRepository seatRepository;

      @Autowired
      private SeatService seatService;

      @Autowired
      private BusServiceImpl busService;

      public BusBookingDto createBusBooking(String email, Long busId, Long routeId) {
            double rate = 5;
            // bus fare 5 rupee per km
            User user = userRepository.findByEmail(email);
            BusDTO busDto = busService.getBusById(busId);
            Bus bus=modelMapper.map(busDto,Bus.class);
            Route route = routeRepository.findById(routeId).get();
            List<SeatDTO> seats = seatService.getAllSeats(busId);

            try {
                  BusBooking busBooking = new BusBooking();
                  busBooking.setBookingDate(new Date());
                  double price = route.getDistance() * rate;
                  busBooking.setBookingPrice(price);
                  busBooking.setSeatNumber(seats.get(0).getSeatNumber());
                  Seat seat = seatRepository.findById(seats.get(0).getId()).get();
                  seat.setSeatBookStatus("BOOKED");
                  seatRepository.save(seat);
                  busBooking.setBusBookingStatus("BOOKED");
                  busBooking.setPaymentStatus("PENDING");
                  busBooking.setUser(user);
                  busBooking.setBus(bus);
                  BusBooking saved = busBookingRepository.save(busBooking);
                  BusBookingDto busBookingDto = modelMapper.map(saved, BusBookingDto.class);
                  // busBookingDto.setUser(modelMapper.map(user, UserDto.class));
                  // busBookingDto.setBus(modelMapper.map(bus, BusDTO.class));
                 
                  return busBookingDto;

            } 
            catch (Exception e) {
                  System.out.println("some thing  went wrong");
            }

            return null;
      }

      public List<BusBookingDto> getAllBookings() {

            List<BusBookingDto> list = new ArrayList<>();
            List<BusBooking> bookings = busBookingRepository.findAll();

            for (BusBooking busBooking : bookings) {

                  BusBookingDto busBookingDto = modelMapper.map(busBooking, BusBookingDto.class);

                  // BusBookingDto.setUser(modelMapper.map(BusBooking.getUser(), UserDto.class));
                  BusDTO busDto = busService.getBusById(busBooking.getBus().getId());
                  busBookingDto.setBus(busDto);
                  list.add(busBookingDto);

            }
            return list;

      }

      public String deleteBusBooking(Long id){

             busBookingRepository.deleteById(id);
             return "Bus Booking deleted successfully with id :"+id;
      }

}
