package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "hotel_id",nullable = false)
	    private Hotel hotel;
	    
	    private String customerName;
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;
		

}
