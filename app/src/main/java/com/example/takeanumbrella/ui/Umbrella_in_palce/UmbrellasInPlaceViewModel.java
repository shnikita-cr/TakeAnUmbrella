package com.example.takeanumbrella.ui.Umbrella_in_palce;

import androidx.lifecycle.ViewModel;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.takeanumbrella.data.Rental.Rental;
import com.example.takeanumbrella.data.Rental.RentalController;
import com.example.takeanumbrella.data.Umbrella.Umbrella;
import com.example.takeanumbrella.data.Umbrella.UmbrellaCOntroller;
import com.example.takeanumbrella.ui.profile.ProfileViewModel;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class UmbrellasInPlaceViewModel extends ViewModel {
    private MutableLiveData<List<Umbrella>> Umbrellas;
    public UmbrellasInPlaceViewModel(){
        Umbrellas = new MutableLiveData<>();
    }

    public void loadUmbrellaInPlace(Long placeId) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<List<Umbrella>> callableTask = () -> {
            return UmbrellaCOntroller.getRentalInfo(placeId);
        };

        Future<List<Umbrella>> future = executorService.submit(callableTask);


        try {
            Umbrellas = new MutableLiveData<>(future.get());
            Log.d("rentalHistory", String.valueOf(Objects.requireNonNull(Umbrellas.getValue()).size()));
        } catch (Exception e) {
            Log.e("RentalHistoryError", e.toString());
            Umbrellas = new MutableLiveData<>(Collections.emptyList());
        } finally {
            executorService.shutdown();
        }

    }
    public MutableLiveData<List<Umbrella>> getUmbrellas(Long clientId) {
        loadUmbrellaInPlace(clientId);
        return Umbrellas;
    }
}