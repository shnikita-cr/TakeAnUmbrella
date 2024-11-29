package com.example.takeanumbrella.data.Umbrella;

import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaColor;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaSize;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaStatus;

public class Umbrella {
    private Long umbrellaId;

    private UmbrellaSize size;

    private UmbrellaColor color;

    private UmbrellaStatus status;

    private RentalLocation location;


    public Umbrella(UmbrellaSize size, UmbrellaColor color, UmbrellaStatus status, RentalLocation location) {
        this.size = size;
        this.color = color;
        this.status = status;
        this.location = location;
    }

}
