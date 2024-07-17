package com.numetry.Travel.and.Tourism.Management.System.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HotelDto {
     
       
       private Long id;
	    private String name;
		private String type;
	    private String address;
	    private String city;
	    private String state;
	    private int rating;
        private double price;
	    private String fileName;
		@Column(length=4000000)
		private byte[] file;
		private String fileType;
     
}
