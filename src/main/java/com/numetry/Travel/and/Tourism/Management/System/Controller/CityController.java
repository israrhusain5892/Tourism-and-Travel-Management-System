package com.numetry.Travel.and.Tourism.Management.System.Controller;

import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @PostMapping("/{stateName}")
    public CityDto addCity(@RequestBody CityDto cityDto, @PathVariable String stateName){
           return cityService.addCity(cityDto,stateName);
    }

    @GetMapping("/{stateName}")
    public List<CityDto> getAllCities(@PathVariable String stateName){
          return cityService.getAllCitiesByStateName(stateName);
    }

    @GetMapping("/")
    public List<CityDto> getAllCities(){
        return cityService.getAllCities();
    }
}
