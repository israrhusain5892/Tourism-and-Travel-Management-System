package com.numetry.Travel.and.Tourism.Management.System.Dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class TripCategoryDto {

    private UUID tripCategoryId;
    @Column(unique = true)
    private String categoryName;
}
