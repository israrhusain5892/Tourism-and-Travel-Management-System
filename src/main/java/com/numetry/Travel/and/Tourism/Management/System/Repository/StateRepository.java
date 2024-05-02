package com.numetry.Travel.and.Tourism.Management.System.Repository;

//import com.numetry.Travel.and.Tourism.Management.System.Model.Country;
import com.numetry.Travel.and.Tourism.Management.System.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<State, UUID> {

    State findByStateName(String stateName);
}
