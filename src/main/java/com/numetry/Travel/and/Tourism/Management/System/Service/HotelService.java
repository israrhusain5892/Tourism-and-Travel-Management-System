package com.numetry.Travel.and.Tourism.Management.System.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelResponse;
import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ModelMapper mapper;

	public List<HotelResponse> getAllHotels() {

		List<HotelResponse> list = new ArrayList<>();
		List<Hotel> hotels = hotelRepository.findAll();
		
		for (Hotel hotel : hotels) {
			String url = "";
			HotelResponse res = mapper.map(hotel, HotelResponse.class);
			url = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/public/hotel/download/")
					.path(res.getId() + "")
					.toUriString();
			res.setUrl(url);
			list.add(res);
		}
		return list;

	}

	public HotelDto getHotelById(Long id) {
		Hotel hotel = hotelRepository.findById(id).get();
		return mapper.map(hotel, HotelDto.class);
	}

	public HotelResponse addHotel(HotelDto hotelDto, MultipartFile file) throws IOException {
		Hotel hotel = mapper.map(hotelDto, Hotel.class);
		hotel.setFileName(file.getOriginalFilename());
		hotel.setFile(file.getBytes());
		hotel.setFileType(file.getContentType());
		hotelRepository.save(hotel);
		return mapper.map(hotelRepository.save(hotel), HotelResponse.class);
	}

	public void deleteHotel(Long id) {
		hotelRepository.deleteById(id);
	}
}
