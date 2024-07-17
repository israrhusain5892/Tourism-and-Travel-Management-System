package com.numetry.Travel.and.Tourism.Management.System.Model;
import java.util.Date;
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

		public Long getBookingId() {
			return bookingId;
		}

		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public int getBookForDays() {
			return bookForDays;
		}

		public void setBookForDays(int bookForDays) {
			this.bookForDays = bookForDays;
		}

		public double getBookingPrice() {
			return bookingPrice;
		}

		public void setBookingPrice(double bookingPrice) {
			this.bookingPrice = bookingPrice;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public TourPackageBooking getTourPackageBooking() {
			return tourPackageBooking;
		}

		public void setTourPackageBooking(TourPackageBooking tourPackageBooking) {
			this.tourPackageBooking = tourPackageBooking;
		}
		
	   
}
