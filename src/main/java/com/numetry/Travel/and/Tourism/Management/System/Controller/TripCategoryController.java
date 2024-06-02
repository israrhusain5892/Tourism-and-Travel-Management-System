package com.numetry.Travel.and.Tourism.Management.System.Controller;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TripCategoryDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.TripCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/tripCategory")
@CrossOrigin
public class TripCategoryController {

    @Autowired
    private TripCategoryServiceImpl tripCategoryService;

    @PostMapping("/")
      public TripCategoryDto addTripCategory(@RequestBody TripCategoryDto tripCategoryDto){
             return tripCategoryService.addTripCategory(tripCategoryDto);
      }

      @GetMapping("/")
      public List<TripCategoryDto> getAllCategories(){
          return tripCategoryService.getAllTrips();
      }


}
