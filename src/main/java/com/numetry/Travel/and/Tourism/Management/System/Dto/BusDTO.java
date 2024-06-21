package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {

    private Long id;
    private String bus_number;
    private String busType;
    private Integer capacity;
    private RouteDTO route;
    private String imageUrl;
   
 }

