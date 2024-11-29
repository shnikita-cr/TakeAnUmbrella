package com.example.takeanumbrella.data.RentalLocation;

public class RentalLocation {
    private Long locationId;

    private String adress;

    private Coordinates location;

    private RentalLocationStatus status;


    public RentalLocation(String address, Coordinates location, RentalLocationStatus status) {
        this.adress = address;
        this.location = location;
        this.status = status;
    }
}
