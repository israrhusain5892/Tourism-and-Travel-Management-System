package com.numetry.Travel.and.Tourism.Management.System.Model;

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
public class TourPlace {
    
       @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
       private Long placeId;

       private String placeName;
       private double price;
       private String address;
       private String placeCateogry;
       private String city;
       private String state;
       private String ImageUrl;

      @ManyToOne
      @JoinColumn(name="tourPackage_id")
      private TourPackage tourPackage;

      @ManyToOne
      @JoinColumn(name="tourPlaceBookingId")
      private TourPlaceBooking tourPlaceBooking;


}
