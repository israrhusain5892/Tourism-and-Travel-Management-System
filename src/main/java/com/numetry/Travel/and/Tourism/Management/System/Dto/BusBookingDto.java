package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusBookingDto {
    
     private Long busBookingId;
     private Double bookingPrice;
     private Integer seatNumber;
     private Date bookingDate;
     private UserDto user;
     private BusDTO bus;

    
    
       
}
