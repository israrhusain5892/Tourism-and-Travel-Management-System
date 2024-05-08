package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;

import java.util.List;

public interface CityService {

    CityDto addCity(CityDto cityDto,String stateName);
    List<CityDto> getAllCitiesByStateName(String stateName);

    List<CityDto> getAllCities();


}
