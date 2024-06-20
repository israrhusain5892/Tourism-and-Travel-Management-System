package com.numetry.Travel.and.Tourism.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.numetry.Travel.and.Tourism.Management.System.Model.Route;



public interface RouteRepository extends JpaRepository<Route, Long> {
	
	@Query("SELECT r FROM Route r WHERE r.origin = :origin AND r.destination = :destination")
	Route findByOriginAndDestination(@Param("origin") String origin, @Param("destination") String destination);
}

