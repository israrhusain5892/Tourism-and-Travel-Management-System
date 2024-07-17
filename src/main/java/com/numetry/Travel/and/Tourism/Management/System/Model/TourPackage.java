package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPackage {

      @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long tourPackageId;
     private double packagePrice;
     @OneToMany(mappedBy="tourPackage",cascade=CascadeType.ALL, orphanRemoval = true)
     private List<TourPlace> places=new ArrayList<>();

//      @OneToMany(mappedBy="tourPackage",cascade=CascadeType.ALL, orphanRemoval = true)
//      private List<TourPackageBooking> bookings=new ArrayList<>();


     @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="hotel_id")
     private Hotel hotel;

     @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="bus_id")
     private Bus bus;


}
