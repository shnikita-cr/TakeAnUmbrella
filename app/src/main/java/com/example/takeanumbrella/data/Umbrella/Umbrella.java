package com.example.takeanumbrella.data.Umbrella;

import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaColor;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaSize;
import com.example.takeanumbrella.data.Umbrella.states.UmbrellaStatus;

public class Umbrella {
    private Long umbrellaId;

    private final UmbrellaSize size;

    private final UmbrellaColor color;

    private final UmbrellaStatus status;

    private final RentalLocation location;


    public Umbrella(UmbrellaSize size, UmbrellaColor color, UmbrellaStatus status, RentalLocation location) {
        this.size = size;
        this.color = color;
        this.status = status;
        this.location = location;
    }

}
