package com.numetry.Travel.and.Tourism.Management.System.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Hotel {


     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
      private UUID hotelId;

       private String hotelName;
       private String hotelAddress;
       private String hotelType;
       private double hotelPrice;


}



























