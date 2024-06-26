package com.numetry.Travel.and.Tourism.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.Bus;
import com.numetry.Travel.and.Tourism.Management.System.Model.Seat;
import com.numetry.Travel.and.Tourism.Management.System.Model.Trip;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Seat findByTripAndSeatNumber(Trip trip, Integer seatNumber);
    // Additional query methods can be defined here if needed
    List<Seat> findByBus(Bus bus);
}

