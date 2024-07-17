package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {

    private Long id;
    private Integer seatNumber;
    private String seatBookStatus;


    
}
