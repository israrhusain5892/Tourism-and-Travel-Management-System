package com.numetry.Travel.and.Tourism.Management.System.Service;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripCategoryDto;


import java.util.List;

public interface TripCategoryService {

      TripCategoryDto addTripCategory(TripCategoryDto tripCategoryDto);
      List<TripCategoryDto> getAllTrips();
}
