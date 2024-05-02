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
public class TripCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tripCategoryId;
    @Column(unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "tripCategory",cascade = CascadeType.ALL)
    private List<Trip> tripList=new ArrayList<>();


}
