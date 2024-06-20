package com.numetry.Travel.and.Tourism.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.Travel.and.Tourism.Management.System.Model.Seat;
import com.numetry.Travel.and.Tourism.Management.System.Model.Trip;



public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findByTripAndSeatNumber(Trip trip, Integer seatNumber);
    // Additional query methods can be defined here if needed
}

