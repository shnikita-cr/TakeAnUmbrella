package com.example.takeanumbrella.ui.rentallocations;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.data.RentalLocation.Coordinates;
import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.data.RentalLocation.RentalLocationController;
import com.example.takeanumbrella.data.RentalLocation.RentalLocationStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RentalLocationsViewModel extends ViewModel {

    private MutableLiveData<List<RentalLocation>> rentalLocations;


    public RentalLocationsViewModel() {
        rentalLocations = new MutableLiveData<>(new ArrayList<>());
    }

    private void loadRentalLocations(String searchQuery) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<List<RentalLocation>> callableTask = () -> {
            return RentalLocationController.getRentalLocationsSync(searchQuery);
        };

        Future<List<RentalLocation>> future = executorService.submit(callableTask);

        rentalLocations = new MutableLiveData<>();

        try {
            rentalLocations = new MutableLiveData<>(future.get());
            Log.d("rentalLocations", String.valueOf(Objects.requireNonNull(rentalLocations.getValue()).size()));
        } catch (Exception e) {
            Log.e("RentalLocationError", e.toString());
            rentalLocations = new MutableLiveData<>(Collections.emptyList());
        } finally {
            executorService.shutdown();
        }
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations(String searchQuery) {
//        loadRentalLocations(searchQuery);
        rentalLocations = new MutableLiveData<>(List.of(
                new RentalLocation("address 1", new Coordinates(0, 0), RentalLocationStatus.OPEN, 53L),
                new RentalLocation("address 2", new Coordinates(0, 0), RentalLocationStatus.OPEN, 38L),
                new RentalLocation("address 3", new Coordinates(0, 0), RentalLocationStatus.OPEN, 53L)
        ));

        return rentalLocations;
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations() {
        return rentalLocations;
    }
}