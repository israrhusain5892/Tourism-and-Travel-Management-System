package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripResponse {

    private UUID tripId;
    private String tripName;
    private String tripAddress;
    private double tripPrice;
    private String url;
}
