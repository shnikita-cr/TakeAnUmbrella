package com.example.takeanumbrella.data.Rental;

import java.sql.Timestamp;

public class Rental {
    private final Timestamp startTimeStamp;
    private Long rentalId;
    private Timestamp endTimeStamp = null;
    private Long rentalCost;
    public Rental(Timestamp startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Timestamp getEndTimeStamp() {
        return endTimeStamp;
    }
    public long getDuration(){
        return endTimeStamp.getTime() - startTimeStamp.getTime();
    }
    public Long getRentalId(){
        return rentalId;
    }
    public Timestamp getStartTimeStamp() {
        return startTimeStamp;
    }
    public Long getRentalCost(){
        return rentalCost;
    }
    public void setEndTimeStamp(Timestamp endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", startTimeStamp=" + startTimeStamp +
                ", endTimeStamp=" + endTimeStamp +
                '}';
    }
}
