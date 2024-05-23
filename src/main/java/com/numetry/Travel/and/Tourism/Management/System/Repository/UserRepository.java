package com.numetry.Travel.and.Tourism.Management.System.Repository;

import com.numetry.Travel.and.Tourism.Management.System.Model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

       User findByEmail(String username);
}
