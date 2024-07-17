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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPlaceBooking {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long tourPlaceBookingId;

     private double TourPlaceBookingPrice;
     private String bookingStatus;
     private Date bookingDate;
     private String paymentStatus;
     private Integer numberofBookedPlaces;

     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;
}

//      @OneToMany(mappedBy = "tourPlaceBooking", cascade = CascadeType.ALL, orphanRemoval = true)
//      private List<TourPlace> tourPlaces=new ArrayList<>();
// }
