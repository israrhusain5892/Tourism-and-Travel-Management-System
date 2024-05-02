package com.numetry.Travel.and.Tourism.Management.System.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.City;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    List<City> findByState(State state);
    City findByCityName(String cityName);
}
