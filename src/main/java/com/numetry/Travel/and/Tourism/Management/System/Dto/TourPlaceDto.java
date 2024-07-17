package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPlaceDto {
     
      private Long placeId;
      private String placeName;
      private double price;
      private String address;
      private String placeCateogry;
      private String city;
      private String state;
      private String ImageUrl;
}
