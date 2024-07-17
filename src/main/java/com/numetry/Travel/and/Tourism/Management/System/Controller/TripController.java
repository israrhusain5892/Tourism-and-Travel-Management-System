package com.numetry.Travel.and.Tourism.Management.System.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripResponse;
import com.numetry.Travel.and.Tourism.Management.System.Dto.UserDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/trip")
@CrossOrigin
public class TripController {

    @Autowired
    private TripServiceImpl tripService;

    @Autowired
    private ObjectMapper objectMapper;

   
    @PostMapping("/{stateName}/{cityName}/{categoryName}")
    public ResponseEntity<?> addTrip(@RequestParam("tripData") String tripData, @PathVariable String stateName,
                                @PathVariable String cityName, @PathVariable String categoryName, @RequestParam("tripPhoto") MultipartFile tripPhoto) throws IOException {
        TripDto tripDto=objectMapper.readValue(tripData, TripDto.class);

         List<TripResponse> trips=tripService.getAllTrips();
         boolean tripExists=trips.stream().anyMatch(
               trip->trip.getTripName().toLowerCase().equals(tripDto.getTripName().toLowerCase())
            );
         if(tripExists){
            return new ResponseEntity<>("Trip with this "+tripDto.getTripName()+" already Added !!",HttpStatus.ACCEPTED);  
         }
          
          String url="";
          
         TripResponse res=tripService.addTrip(tripDto,stateName,cityName,categoryName,tripPhoto);

        url= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/public/trip/download/")
                .path(res.getTripId()+"")
                .toUriString();
        res.setUrl(url);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable UUID id){
        TripDto tripDto=tripService.getTripById(id);
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(tripDto.getFileType())).
                header(HttpHeaders.CONTENT_DISPOSITION,"movie; fileName = \"" +tripDto.getTripPhotoName()+"\"").
                body(new ByteArrayResource(tripDto.getTripPhoto()));
    }

    @GetMapping("/")
    public List<TripResponse> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{stateName}")
    public List<TripResponse> getTripsByState(@PathVariable String stateName){
           return tripService.getTripsByStateName(stateName);
    }

    @GetMapping("/getCityWise/{cityName}")
    public List<TripResponse> getTripsByCity(@PathVariable String cityName){
        return tripService.getTripsByCityName(cityName);
    }

    @GetMapping("/getCategoryWise/{categoryName}")
    public List<TripResponse> getTripsByCategory(@PathVariable String categoryName){
        return tripService.getTripsByCategoryName(categoryName);
    }

}
