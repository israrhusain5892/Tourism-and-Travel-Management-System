package com.numetry.Travel.and.Tourism.Management.System.Dto;

public class SeatDTO {

    private Long id;
    private Integer seatNumber;
    private Double fare;

    public SeatDTO() {}

    public SeatDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

	public SeatDTO(Long id, Integer seatNumber, Double fare) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.fare = fare;
	}
    
}
