package com.numetry.Travel.and.Tourism.Management.System.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.City;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
import com.numetry.Travel.and.Tourism.Management.System.Model.Trip;
import com.numetry.Travel.and.Tourism.Management.System.Model.TripCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {
    List<Trip> findTripByState(State state);

    List<Trip> findTripByCity(City city);

//    List<Trip> findByCategory(TripCategory tripCategory);

    List<Trip> findByTripCategory(TripCategory tripCategory);
}
