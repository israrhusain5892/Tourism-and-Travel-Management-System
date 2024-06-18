
package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.HotelResponse;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import com.numetry.Travel.and.Tourism.Management.System.Model.Hotel;
import com.numetry.Travel.and.Tourism.Management.System.Service.HotelService;

@RestController
@RequestMapping("/public/hotel")
@CrossOrigin
public class HotelController {
	@Autowired
	private HotelService hotelService;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/")
	public List<HotelResponse> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public HotelDto getHotelById(@PathVariable Long id) {
		return hotelService.getHotelById(id);
	}

	@PostMapping
	public HotelResponse addHotel(@RequestParam("hotelData") String hotelData, MultipartFile file) throws IOException {

		String url = "";
		HotelDto hotelDto = objectMapper.readValue(hotelData, HotelDto.class);
		HotelResponse res = hotelService.addHotel(hotelDto, file);

		url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/public/hotel/download/")
				.path(res.getId() + "")
				.toUriString();
		res.setUrl(url);
		return res;
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> download(@PathVariable Long id) {
		HotelDto hotelDto = hotelService.getHotelById(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(hotelDto.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "movie; fileName = \"" + hotelDto.getFileName() + "\"")
				.body(new ByteArrayResource(hotelDto.getFile()));
	}

	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotel(id);
	}
}
