package com.numetry.Travel.and.Tourism.Management.System.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourCartId;
    private String tripName;
    private String tripAddress;
    private double tripPrice;
    private String url;

    @ManyToOne
    @JoinColumn
    private TourCart tourCart;
}
