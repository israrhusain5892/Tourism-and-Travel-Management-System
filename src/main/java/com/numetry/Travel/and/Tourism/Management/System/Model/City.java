package com.numetry.Travel.and.Tourism.Management.System.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cityId;
    private String cityName;

    @ManyToOne
    @JoinColumn(name="stateId")
    private State state;
}
