package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.numetry.Travel.and.Tourism.Management.System.Dto.BusDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelResponse;
import com.numetry.Travel.and.Tourism.Management.System.Dto.SeatDTO;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TourPackageBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TourPackageDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.BusBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.HotelBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.Seat;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPackage;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPackageBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPlace;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPlaceBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Repository.BusBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.SeatRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TourPackageBookingRepo;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TourPackageRepo;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TourPlaceBookingRepository;

import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.BusServiceImpl;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TourPackageBookingService {

      @Autowired
      private ModelMapper modelMapper;

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private TourPackageBookingRepo tourPackageBookingRepo;

      @Autowired
      private TourPackageRepo tourPackageRepo;

      @Autowired
      private SeatService seatService;

      @Autowired
      private BusServiceImpl busService;

      @Autowired
      private HotelBookingRepository hotelBookingRepository;

      @Autowired
      private SeatRepository seatRepository;

      @Autowired
      private TourPlaceBookingRepository tourPlaceBookingRepo;

      @Autowired
      private BusBookingRepository busBookingRepository;

      @Transactional
      public TourPackageBookingDto createTourBooking(Integer userId, Long tourPackageId, Integer distance,
                  Integer bookForDays) {

            User user = userRepository.findById(userId).get();
            TourPackage tourPackage = tourPackageRepo.findById(tourPackageId).get();

            List<SeatDTO> seats = seatService.getAllSeats(tourPackage.getBus().getId());

            try {

                  // tour plac eBooking
                  TourPlaceBooking tourPlaceBooking = new TourPlaceBooking();
                  tourPlaceBooking.setBookingDate(new Date());
                  tourPlaceBooking.setBookingStatus("BOOKED");
                  tourPlaceBooking.setNumberofBookedPlaces(tourPackage.getPlaces().size());
                  tourPlaceBooking.setUser(user);
                  double tourPlaceBookingPrice = 0;
                  for (TourPlace place : tourPackage.getPlaces()) {
                        place.setTourPlaceBooking(tourPlaceBooking);
                        tourPlaceBookingPrice += place.getPrice();
                  }
                  tourPlaceBooking.setTourPlaceBookingPrice(tourPlaceBookingPrice);
                  tourPlaceBooking.setPaymentStatus("PENDING");
                  // save tour place booking data
                  tourPlaceBookingRepo.save(tourPlaceBooking);

                  // Create Bus Booking
                  BusBooking busBooking = new BusBooking();
                  busBooking.setBookingDate(new Date());
                  double pr = distance * 5;
                  busBooking.setBookingPrice(pr);
                  busBooking.setSeatNumber(seats.get(0).getSeatNumber());
                  Seat seat = seatRepository.findById(seats.get(0).getId()).get();
                  seat.setSeatBookStatus("BOOKED");
                  seatRepository.save(seat);
                  busBooking.setBus(tourPackage.getBus());
                  busBooking.setUser(user);
                  busBookingRepository.save(busBooking);

                  // Create Hotel Booking
                  HotelBooking hotelBooking = new HotelBooking();

                  hotelBooking.setBookingDate(new Date());
                  hotelBooking.setStatus("BOOKED");
                  hotelBooking.setBookForDays(bookForDays);
                  double price = tourPackage.getHotel().getPrice();
                  hotelBooking.setBookingPrice(price * bookForDays);
                  hotelBooking.setPaymentStatus("PENDING");
                  List<HotelBooking> bookings = user.getHotelBookings();
                  bookings.add(hotelBooking);
                  user.setHotelBookings(bookings);
                  hotelBooking.setUser(user);
                  List<HotelBooking> bookings2 = tourPackage.getHotel().getHotelBookings();
                  bookings2.add(hotelBooking);
                  tourPackage.getHotel().setHotelBookings(bookings2);
                  hotelBooking.setHotel(tourPackage.getHotel());
                  // save hotel Booking
                  hotelBookingRepository.save(hotelBooking);

                  // create tour package Booking
                  TourPackageBooking tourPackageBooking = new TourPackageBooking();

                  tourPackageBooking.setBookingStatus("BOOKED");
                  double price1 = tourPackage.getPackagePrice() + tourPackage.getHotel().getPrice() * bookForDays
                              + distance * 5;
                  tourPackageBooking.setBookingPrice(price1);
                  List<User> users = tourPackageBooking.getUser();
                  users.add(user);
                  tourPackageBooking.setUser(users);

                  tourPackageBooking.setBusBooking(busBooking);
                  tourPackageBooking.setHotelBooking(hotelBooking);
                  tourPackageBooking.setTourPlaceBooking(tourPlaceBooking);
                  user.setTourPackageBooking(tourPackageBooking);
                  userRepository.save(user);
                  TourPackageBooking savedBooking = tourPackageBookingRepo.save(tourPackageBooking);

                  TourPackageBookingDto tourPackageBookingDto = modelMapper.map(savedBooking,
                              TourPackageBookingDto.class);
                  String id = "TourBK3433" + savedBooking.getTourPackageBookingId();
                  tourPackageBookingDto.setTourPackageBookingId(id);

                  TourPackageDto tourPackageDto = modelMapper.map(tourPackage, TourPackageDto.class);
                  HotelResponse res = tourPackageBookingDto.getHotelBooking().getHotel();
                  String url = "";
                  url = ServletUriComponentsBuilder.fromCurrentContextPath()
                              .path("/public/hotel/download/")
                              .path(res.getId() + "")
                              .toUriString();
                  res.setUrl(url);
                  tourPackageBookingDto.getTourPlaceBooking().setBookedPlaces(tourPackageDto.getPlaces());
                  return tourPackageBookingDto;

            }

            catch (Exception e) {
                  e.printStackTrace();
            }
            return null;

      }

      public String deleteBookings(String id) {
            char c = id.charAt(id.length() - 1);
            Long tourBookingId = Long.valueOf(c - '0');

            TourPackageBooking tourPackageBooking = tourPackageBookingRepo.findById(tourBookingId)
                        .orElseThrow(() -> new EntityNotFoundException("Parent not found"));

            // Unlink the children from the parent
            List<User> users = tourPackageBooking.getUser();
            if (!users.isEmpty()) {
                  for (User user : tourPackageBooking.getUser()) {
                        user.setTourPackageBooking(null);
                        userRepository.save(user);
                  }
            }

            // Now delete the parent
            tourPackageBookingRepo.delete(tourPackageBooking);
            return "Tour package Booking deleted successfully";
      }

      public List<TourPackageBookingDto> getAllTourPackageBookings() {

            List<TourPackageBookingDto> list = new ArrayList<>();
            List<TourPackageBooking> bookings = tourPackageBookingRepo.findAll();

            for (TourPackageBooking tourPackageBooking : bookings) {
                  TourPackage tourPackage = tourPackageRepo
                              .findByBusId(tourPackageBooking.getBusBooking().getBus().getId());
                  BusDTO busDto=busService.getBusById(tourPackage.getBus().getId());
                  TourPackageBookingDto tourPackageBookingDto = modelMapper.map(tourPackageBooking,
                              TourPackageBookingDto.class);
                  TourPackageDto tourPackageDto = modelMapper.map(tourPackage, TourPackageDto.class);
                  HotelResponse res = tourPackageBookingDto.getHotelBooking().getHotel();
                  String url = "";
                  url = ServletUriComponentsBuilder.fromCurrentContextPath()
                              .path("/public/hotel/download/")
                              .path(res.getId() + "")
                              .toUriString();
                  res.setUrl(url);
                  tourPackageBookingDto.getTourPlaceBooking().setBookedPlaces(tourPackageDto.getPlaces());
                  String id = "TourBK3433" + tourPackageBooking.getTourPackageBookingId();
                  tourPackageBookingDto.setTourPackageBookingId(id);
                  tourPackageBookingDto.getBusBooking().setBus(busDto);
                  list.add(tourPackageBookingDto);

            }
            return list;

      }

}
