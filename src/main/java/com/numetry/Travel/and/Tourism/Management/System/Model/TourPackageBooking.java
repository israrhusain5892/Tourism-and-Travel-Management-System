package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TourPackageBooking {
     
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long TourPackageBookingId;

      private String bookingStatus;
      private double bookingPrice;
      private Date bookingDate;

      @OneToMany(mappedBy = "tourPackageBooking", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
      private List<User> user=new ArrayList<>();
      
      @OneToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="tourPlaceBookingId")
      private TourPlaceBooking tourPlaceBooking;

      @OneToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="hotelBookingId")
      private HotelBooking hotelBooking;

      @OneToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="busBookingId")
      private BusBooking busBooking;
      

      
       
}
