package com.numetry.Travel.and.Tourism.Management.System.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private UUID tripId;
    private String tripName;
    private String tripAddress;
    private double tripPrice;
    private String tripPhotoName;
    @Column(length=4000000)
    private byte[] tripPhoto;
    private String fileType;
}
