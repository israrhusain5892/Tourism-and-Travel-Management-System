package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPlaceBookingDto {

    private Long tourPlaceBookingId;
    private double bookingPrice;
    private String bookingStatus;
    private Date bookingDate;
    private String paymentStatus;
    private Integer numberofBookedPlaces;
    List<TourPlaceDto> bookedPlaces;
}
