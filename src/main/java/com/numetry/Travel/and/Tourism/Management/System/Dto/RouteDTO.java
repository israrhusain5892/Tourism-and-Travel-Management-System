package com.numetry.Travel.and.Tourism.Management.System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

    private Long id;
    private String origin;
    private String destination;
    private Double distance;
    private String departTime;
    private String arriveTime;
    

}
