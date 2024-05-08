package com.numetry.Travel.and.Tourism.Management.System.Model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class State {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID stateId;
    private String stateName;


    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private List<City> cityList=new ArrayList<>();
}
