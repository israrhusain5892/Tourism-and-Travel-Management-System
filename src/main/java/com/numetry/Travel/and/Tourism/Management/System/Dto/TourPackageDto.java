package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.util.List;

import com.numetry.Travel.and.Tourism.Management.System.Model.TourPlace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPackageDto {
     
    private Long tourPackageId;
    private double tourPackagePrice;
    private List<TourPlaceDto> places;
    private HotelResponse hotel;
    private BusDTO bus;
    
}
