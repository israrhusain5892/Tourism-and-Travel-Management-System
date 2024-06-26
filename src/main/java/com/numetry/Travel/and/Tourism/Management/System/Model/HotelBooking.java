


package com.numetry.Travel.and.Tourism.Management.System.Model;
import java.time.LocalDate;
import java.util.Date;

// import org.springframework.data.relational.core.sql.FalseCondition;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelBooking {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookingId;
        private String status;
		private Date bookingDate;
		private int bookForDays;
		private double bookingPrice;
        private String paymentStatus;
		@ManyToOne
		@JoinColumn(name="userId")
		private User user;
	    
	    @ManyToOne
	    @JoinColumn(name = "hotel_id",nullable = false)
	    private Hotel hotel;
	    
		@OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="tourPackageBookingId")
        private TourPackageBooking tourPackageBooking;
	   
}
