package com.numetry.Travel.and.Tourism.Management.System.Dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDto {
    
        private String bookingId;
        private String bookingStatus;
		private Date bookingDate;
        private int bookForDays;
		private double bookingPrice;
        private String paymentStatus;
        private UserDto user;
	    private HotelResponse hotel;
        
        public String getBookingId() {
            return bookingId;
        }
        public void setBookingId(String bookingId) {
            this.bookingId = bookingId;
        }
        public String getBookingStatus() {
            return bookingStatus;
        }
        public void setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
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
        public UserDto getUser() {
            return user;
        }
        public void setUser(UserDto user) {
            this.user = user;
        }
        public HotelResponse getHotel() {
            return hotel;
        }
        public void setHotel(HotelResponse hotel) {
            this.hotel = hotel;
        }
        
}
