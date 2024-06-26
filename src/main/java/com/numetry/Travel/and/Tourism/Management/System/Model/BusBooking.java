package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusBooking {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long busBookingId;
     private Double bookingPrice;
     private Integer seatNumber;
     private Date bookingDate;
     private String busBookingStatus;
     private String paymentStatus;

     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;

     @ManyToOne
     @JoinColumn(name="bus_id")
     private Bus bus;

     @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="tourPackageBookingId")
     private TourPackageBooking tourPackageBooking;
}
