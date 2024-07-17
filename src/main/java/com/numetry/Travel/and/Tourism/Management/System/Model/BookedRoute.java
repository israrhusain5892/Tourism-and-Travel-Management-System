package com.numetry.Travel.and.Tourism.Management.System.Model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookedRoute {

    private Long id;
    private String origin;
    private String destination;
    private Double distance;
    private String departTime;
    private String arriveTime;
}
