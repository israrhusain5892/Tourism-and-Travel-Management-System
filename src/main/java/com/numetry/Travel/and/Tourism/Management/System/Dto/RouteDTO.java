package com.numetry.Travel.and.Tourism.Management.System.Dto;

public class RouteDTO {

    private Long id;
    private String origin;
    private String destination;
    private Double distance;
    

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    // Constructor
    public RouteDTO(Long id, String origin, String destination, Double distance) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }
}
