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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "operator_id")
    // private Operator operator;
    private String bus_number;
    private String busType;
    private Integer capacity;
    private Integer seatAvailable;
    private String imageUrl;
    

    @OneToMany(mappedBy="bus",cascade=CascadeType.ALL)
    private List<Seat> seats=new ArrayList<>();

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<BusBooking> busBookings=new ArrayList<>();
    
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Route> routes=new ArrayList<>();


}


