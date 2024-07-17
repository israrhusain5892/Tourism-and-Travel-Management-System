package com.numetry.Travel.and.Tourism.Management.System.Controller;

import com.numetry.Travel.and.Tourism.Management.System.Dto.CityDto;
import com.numetry.Travel.and.Tourism.Management.System.Dto.TripCategoryDto;
import com.numetry.Travel.and.Tourism.Management.System.Service.ServiceImpl.TripCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/tripCategory")
@CrossOrigin
public class TripCategoryController {

    @Autowired
    private TripCategoryServiceImpl tripCategoryService;

    @PostMapping("/")
      public ResponseEntity<?> addTripCategory(@RequestBody TripCategoryDto tripCategoryDto){
            
              List<TripCategoryDto> categoryDtos=tripCategoryService.getAllTrips();
             boolean exist=categoryDtos.stream().anyMatch(
                category->category.getCategoryName().toLowerCase().equals(tripCategoryDto.getCategoryName().toLowerCase()));
             if(exist){
                return new ResponseEntity<>(tripCategoryDto.getCategoryName()+" Category already exist",HttpStatus.BAD_REQUEST);
             }
              TripCategoryDto tripCategoryDto2=tripCategoryService.addTripCategory(tripCategoryDto);
             return new ResponseEntity<>(tripCategoryDto2,HttpStatus.ACCEPTED);
             
      }

      @GetMapping("/")
      public List<TripCategoryDto> getAllCategories(){
          return tripCategoryService.getAllTrips();
      }


}
