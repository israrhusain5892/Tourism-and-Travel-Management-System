package com.numetry.Travel.and.Tourism.Management.System.Dto;
import lombok.Data;

@Data
public class HotelResponse {
    
    private Long id;
    private String name;
    private String type;
    private String address;
    private String city;
    private String state;
    private int rating;
    private double price;
    private String url;
}
