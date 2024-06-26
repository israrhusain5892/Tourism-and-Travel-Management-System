package com.numetry.Travel.and.Tourism.Management.System.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.Travel.and.Tourism.Management.System.Dto.TourPackageDto;
import com.numetry.Travel.and.Tourism.Management.System.Model.TourPackage;
import com.numetry.Travel.and.Tourism.Management.System.Repository.TourPackageRepo;
import com.numetry.Travel.and.Tourism.Management.System.Service.TourPackageService;

@RestController
@CrossOrigin
@RequestMapping("/public/tourPackage")
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    @Autowired
    private TourPackageRepo tourPackageRepo;

    @PostMapping("/{hotel_id}/{bus_id}/{stateName}")
    public TourPackageDto createPackage(@PathVariable Long hotel_id,
            @PathVariable Long bus_id, @PathVariable String stateName) {
        return tourPackageService.createTourPackage(hotel_id, bus_id,stateName);
    }



    @GetMapping("/")
    public List<TourPackageDto> getAllTourPackage(){
          return tourPackageService.getAllTourPackage();
    }

    @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable Long id) {
         
        return tourPackageService.deletePackage(id);
    }
}
