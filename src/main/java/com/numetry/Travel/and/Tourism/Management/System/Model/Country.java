//package com.numetry.Travel.and.Tourism.Management.System.Model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Country {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID countryId;
//    private String countryName;
//
//    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
//    private List<State> stateList=new ArrayList<>();
//
//}
