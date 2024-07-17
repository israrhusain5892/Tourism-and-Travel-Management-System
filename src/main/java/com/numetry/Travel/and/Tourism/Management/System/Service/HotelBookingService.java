package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelBookingDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelResponse;
import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Model.HotelBooking;
import com.numetry.Travel.and.Tourism.Management.System.Model.User;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelBookingRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelRepository;
import com.numetry.Travel.and.Tourism.Management.System.Repository.UserRepository;

@Service
public class HotelBookingService {
	@Autowired
	private HotelBookingRepository bookingRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public HotelBookingDto addBooking(String userName, Long hotelId,int bookForDays) {

		User user = userRepository.findByEmail(userName);
		Hotel hotel = hotelRepository.findById(hotelId).get();

		try {

			HotelBooking hotelBooking = new HotelBooking();

			hotelBooking.setBookingDate(new Date());
			hotelBooking.setStatus("BOOKED");
            hotelBooking.setBookForDays(bookForDays);
			double price=hotel.getPrice();
			hotelBooking.setBookingPrice(price*bookForDays);
			hotelBooking.setPaymentStatus("PENDING");
			List<HotelBooking> bookings = user.getHotelBookings();
			bookings.add(hotelBooking);
			user.setHotelBookings(bookings);
			hotelBooking.setUser(user);
			// User savedUser=userRepository.save(user);

			List<HotelBooking> bookings2 = hotel.getHotelBookings();
			bookings2.add(hotelBooking);
			hotel.setHotelBookings(bookings2);
			hotelBooking.setHotel(hotel);
			// Hotel savedHotel=hotelRepository.save(hotel);

			HotelBooking saved = bookingRepository.save(hotelBooking);
			HotelBookingDto hotelBookingDto = modelMapper.map(saved, HotelBookingDto.class);
			String bookingId = "HOTELBKID" + saved.getBookingId();
			hotelBookingDto.setBookingId(bookingId);
			HotelResponse res = modelMapper.map(hotel, HotelResponse.class);
			String url="";
			url = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/public/hotel/download/")
					.path(res.getId() + "")
					.toUriString();
			res.setUrl(url);
			hotelBookingDto.setHotel(res);
			hotelBookingDto.setUser(modelMapper.map(user, UserDto.class));
			return hotelBookingDto;
		}

		catch (Exception e) {
			System.out.println("some thing went wrong" + e);
		}
		return null;
	}

	public List<HotelBookingDto> getAllBookings() {

		 List<HotelBookingDto> list=new ArrayList<>();
		 List<HotelBooking> bookings=bookingRepository.findAll();
         for(HotelBooking hotelBooking :bookings){
			   
			    HotelBookingDto hotelBookingDto=modelMapper.map(hotelBooking,HotelBookingDto.class);
				String bookingId = "HOTELBKID" + hotelBooking.getBookingId();
			hotelBookingDto.setBookingId(bookingId);
			HotelResponse res = modelMapper.map(hotelBooking.getHotel(), HotelResponse.class);
			String url="";
			url = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/public/hotel/download/")
					.path(res.getId() + "")
					.toUriString();
			res.setUrl(url);
			hotelBookingDto.setHotel(res);
			hotelBookingDto.setUser(modelMapper.map(hotelBooking.getUser(), UserDto.class));
			list.add(hotelBookingDto);

		 }
		 return list;

	}

	public HotelBookingDto getBookingById(Long id) {

		HotelBooking hotelBooking=bookingRepository.findById(id).get();
		HotelBookingDto hotelBookingDto=modelMapper.map(hotelBooking,HotelBookingDto.class);
		String bookingId = "HOTELBKID" + hotelBooking.getBookingId();
		hotelBookingDto.setBookingId(bookingId);
		HotelResponse res = modelMapper.map(hotelBooking.getHotel(), HotelResponse.class);
		String url="";
		url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/public/hotel/download/")
				.path(res.getId() + "")
				.toUriString();
		res.setUrl(url);
		hotelBookingDto.setHotel(res);
	   return hotelBookingDto;
	}

	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
}
