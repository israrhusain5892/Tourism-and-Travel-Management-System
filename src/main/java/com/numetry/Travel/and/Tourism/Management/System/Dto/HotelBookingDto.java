package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDto {
    
        private String bookingId;
        private String bookingStatus;
		private Date bookingDate;
        private int bookForDays;
		private double bookingPrice;
        private String paymentStatus;
        private UserDto user;
	    private HotelResponse hotel;
}
