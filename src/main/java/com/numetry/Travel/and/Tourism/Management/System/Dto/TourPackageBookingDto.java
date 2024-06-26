package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPackageBookingDto {
      
      private String tourPackageBookingId;
      private String bookingStatus;
      private String bookingPrice;
      private Date bookingDate;
      private TourPlaceBookingDto tourPlaceBooking;
      private HotelBookingDto hotelBooking;
      private BusBookingDto busBooking;
}
      
