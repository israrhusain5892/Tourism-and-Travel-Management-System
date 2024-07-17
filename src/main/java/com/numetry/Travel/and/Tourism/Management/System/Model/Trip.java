package com.numetry.Travel.and.Tourism.Management.System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tripId;
    private String tripName;
    private String tripAddress;
    private double tripPrice;
    private String tripPhotoName;
    @Lob
    @Column(length=4000000)
    private byte[] tripPhoto;
    private String fileType;

    @ManyToOne
    @JoinColumn(name="tripCategoryId")
    private TripCategory tripCategory;

    @ManyToOne
    @JoinColumn(name="stateId")
    private State state;

    @ManyToOne
    @JoinColumn(name="cityId")
    private City city;

      
    @OneToMany(mappedBy = "trip",cascade = CascadeType.ALL)
     private List<TripBooking> tripBookings=new ArrayList<>();
      

}

