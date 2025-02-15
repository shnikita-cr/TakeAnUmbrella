package com.example.takeanumbrella.ui.umbrellas;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.data.RentalLocation.RentalLocationController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UmbrellasViewModel extends ViewModel {

    private MutableLiveData<List<RentalLocation>> rentalLocations;


    public UmbrellasViewModel() {
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
            Log.d("rentalLocations", rentalLocations.getValue().get(0).toString());
        } catch (Exception e) {
            Log.e("RentalLocationError", e.toString());
            rentalLocations = new MutableLiveData<>(Collections.emptyList());
        } finally {
            executorService.shutdown();
        }
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations(String searchQuery) {
        loadRentalLocations(searchQuery);
        return rentalLocations;
    }

    public MutableLiveData<List<RentalLocation>> getRentalLocations() {
        return rentalLocations;
    }
}