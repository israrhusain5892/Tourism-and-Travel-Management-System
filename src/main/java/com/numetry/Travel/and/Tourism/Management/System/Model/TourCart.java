package com.numetry.Travel.and.Tourism.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourCart {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long tourCartId;
      
      @OneToMany(mappedBy = "tourCart",cascade = CascadeType.ALL)
      private List<TourCartItem> cartItems=new ArrayList<>();
      
}
