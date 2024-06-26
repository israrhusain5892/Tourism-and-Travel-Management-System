package com.numetry.Travel.and.Tourism.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.TourPackage;

@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage,Long> {

        TourPackage findByBusId(Long id);
} 