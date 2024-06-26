package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
		private String type;
	    private String address;
	    private String city;
	    private String state;
	    private int rating;
		private double pricePerDay;
        
		 private String fileName;
		@Lob
		@Column(length=4000000)
		private byte[] file;
		private String fileType;

		 @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
		 private List<HotelBooking> hotelBookings=new ArrayList<>();

	}

	


