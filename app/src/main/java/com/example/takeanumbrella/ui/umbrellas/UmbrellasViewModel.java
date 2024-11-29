package com.example.takeanumbrella.ui.umbrellas;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.data.Rental.Rental;
import com.example.takeanumbrella.data.RentalLocation.Coordinates;
import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.data.RentalLocation.RentalLocationController;
import com.example.takeanumbrella.data.RentalLocation.RentalLocationStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UmbrellasViewModel extends ViewModel {

    private MutableLiveData<List<RentalLocation>> rentalLocations;

    public UmbrellasViewModel() {
        loadRentalLocations("");
    }

    private void loadRentalLocations(String searchQuery) {
//        rentalLocations = new MutableLiveData<>(RentalLocationController.getRentalLocations(searchQuery));
        ArrayList<RentalLocation> tempRentalLocationHistory = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tempRentalLocationHistory.add(new RentalLocation(
                    "Saint.P", new Coordinates(5, 5), RentalLocationStatus.OPEN
            ));
        }
        rentalLocations = new MutableLiveData<>(tempRentalLocationHistory);
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations(String searchQuery) {
        loadRentalLocations(searchQuery);
        return rentalLocations;
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations() {
        return rentalLocations;
    }
}