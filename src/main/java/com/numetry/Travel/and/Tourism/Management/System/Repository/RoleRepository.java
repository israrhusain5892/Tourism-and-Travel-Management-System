package com.numetry.Travel.and.Tourism.Management.System.Repository;


import com.numetry.Travel.and.Tourism.Management.System.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
