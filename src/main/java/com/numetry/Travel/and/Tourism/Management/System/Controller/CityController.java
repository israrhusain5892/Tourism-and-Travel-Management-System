package com.numetry.Travel.and.Tourism.Management.System.Controller;

import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.CityServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @PostMapping("/{stateName}")
    public ResponseEntity<?> addCity(@RequestBody CityDto cityDto, @PathVariable String stateName){
            
             List<CityDto> cities=cityService.getAllCities();
             boolean exist=cities.stream().anyMatch(
                city->city.getCityName().toLowerCase().equals(cityDto.getCityName().toLowerCase()));
             if(exist){
                return new ResponseEntity<>(cityDto.getCityName()+" city already exist",HttpStatus.BAD_REQUEST);
             }
              CityDto cityDto2=cityService.addCity(cityDto, stateName);
             return new ResponseEntity<>(cityDto2,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{stateName}")
    public List<CityDto> getAllCities(@PathVariable String stateName){
          return cityService.getAllCitiesByStateName(stateName);
    }

    @GetMapping("/")
    public List<CityDto> getAllCities(){
        return cityService.getAllCities();
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable UUID id){
        return cityService.deleteCity(id);
    }
}
