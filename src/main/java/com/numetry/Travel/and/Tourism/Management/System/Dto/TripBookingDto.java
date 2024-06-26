package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripBookingDto {
      
    private Long tripBookingId;
    private double tripeBookingPrice;
     private String tripBookingStatus;
     private Date bookingDate;
     private String paymentStatus;
     private TripResponse trip;
     private UserDto user;
}
