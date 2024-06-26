package com.numetry.Travel.and.Tourism.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.TourPlace;

@Repository
public interface TourPlaceRepo extends JpaRepository<TourPlace,Long> {

    
} 
