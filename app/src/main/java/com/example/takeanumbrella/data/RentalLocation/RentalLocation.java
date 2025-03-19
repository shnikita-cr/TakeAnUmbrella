package com.example.takeanumbrella.data.RentalLocation;

public class RentalLocation {
    private Long locationId;

    private final String adress;

    private final Coordinates location;

    private final RentalLocationStatus status;
    private final Long validUmbrellaCount;


    public RentalLocation(String address, Coordinates location, RentalLocationStatus status, Long validUmbrellaCount) {
        this.adress = address;
        this.location = location;
        this.status = status;
        this.validUmbrellaCount = validUmbrellaCount;
    }

    public Long getValidUmbrellaCount() {
        return validUmbrellaCount;
    }

    public Long getLocationId() {
        return locationId;
    }

    public String getAdress() {
        return adress;
    }

    public Coordinates getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "RentalLocation{" +
                "locationId=" + locationId +
                ", adress='" + adress + '\'' +
                ", location=" + location +
                ", status=" + status +
                '}';
    }
}
