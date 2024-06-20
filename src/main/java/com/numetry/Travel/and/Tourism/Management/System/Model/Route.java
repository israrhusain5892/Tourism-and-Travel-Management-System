package com.numetry.Travel.and.Tourism.Management.System.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Route {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private Double distance;
	
	public Route() {
		super();
	}
	

   
	public Route(Long id, String origin, String destination, Double distance) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;

	}

    
}
