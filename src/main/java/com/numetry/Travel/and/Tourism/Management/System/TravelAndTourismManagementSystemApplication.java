package com.numetry.Travel.and.Tourism.Management.System;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class TravelAndTourismManagementSystemApplication  {

	// @Bean
	// public PasswordEncoder passwordEncoder2(){
	//  return new BCryptPasswordEncoder();
	// }
	
	public static void main(String[] args) {
		SpringApplication.run(TravelAndTourismManagementSystemApplication.class, args);
	}
     @Bean
    public ModelMapper modelMapper(){
		 return new ModelMapper();
	}
	// @Override
	// public void run(String... args) throws Exception {
	// 	// TODO Auto-generated method stub

	// 	System.out.println(passwordEncoder2().encode("Israr@123"));
	// 	throw new UnsupportedOperationException("Unimplemented method 'run'");
	// }
	

}
