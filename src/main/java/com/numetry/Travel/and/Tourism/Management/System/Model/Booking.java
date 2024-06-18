


package com.numetry.Travel.and.Tourism.Management.System.Model;
import java.time.LocalDate;

// import org.springframework.data.relational.core.sql.FalseCondition;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "hotel_id",nullable = false)
	    private Hotel hotel;
	    
	    private String customerName;
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Hotel getHotel() {
			return hotel;
		}
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public LocalDate getCheckInDate() {
			return checkInDate;
		}
		public void setCheckInDate(LocalDate checkInDate) {
			this.checkInDate = checkInDate;
		}
		public LocalDate getCheckOutDate() {
			return checkOutDate;
		}
		public void setCheckOutDate(LocalDate checkOutDate) {
			this.checkOutDate = checkOutDate;
		}
		public Booking(Long id, Hotel hotel, String customerName, LocalDate checkInDate, LocalDate checkOutDate) {
			super();
			this.id = id;
			this.hotel = hotel;
			this.customerName = customerName;
			this.checkInDate = checkInDate;
			this.checkOutDate = checkOutDate;
		}
		public Booking() {
			
		}

}
