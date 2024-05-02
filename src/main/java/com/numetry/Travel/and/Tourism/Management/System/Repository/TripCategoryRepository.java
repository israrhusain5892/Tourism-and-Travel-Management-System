package com.numetry.Travel.and.Tourism.Management.System.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.TripCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripCategoryRepository extends JpaRepository<TripCategory, UUID> {
    TripCategory findByCategoryName(String categoryName);
}
