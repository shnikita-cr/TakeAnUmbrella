package com.example.takeanumbrella.ui.profile;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.data.Rental.Rental;
import com.example.takeanumbrella.data.Rental.RentalController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> clientName;
    private final MutableLiveData<String> profileInfo;
    private MutableLiveData<List<Rental>> rentalHistory;

    public ProfileViewModel() {
        clientName = new MutableLiveData<>();
        clientName.setValue("Nick");
        profileInfo = new MutableLiveData<>();
        profileInfo.setValue("First client!");
        rentalHistory = new MutableLiveData<>();
    }

    public void loadRentalHistory(Long clientId) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<List<Rental>> callableTask = () -> {
            return RentalController.getRentals(clientId);
        };

        Future<List<Rental>> future = executorService.submit(callableTask);


        try {
            rentalHistory = new MutableLiveData<>(future.get());
            Log.d("rentalHistory", String.valueOf(Objects.requireNonNull(rentalHistory.getValue()).size()));
        } catch (Exception e) {
            Log.e("RentalHistoryError", e.toString());
            rentalHistory = new MutableLiveData<>(Collections.emptyList());
        } finally {
            executorService.shutdown();
        }

    }

    public MutableLiveData<String> getClientName() {
        return clientName;
    }

    public MutableLiveData<String> getProfileInfo() {
        return profileInfo;
    }

    public MutableLiveData<List<Rental>> getRentalHistory(Long clientId) {
        loadRentalHistory(clientId);
        return rentalHistory;
    }
}
