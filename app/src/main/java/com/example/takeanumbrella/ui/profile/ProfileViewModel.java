package com.example.takeanumbrella.ui.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.takeanumbrella.data.Rental.Rental;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> clientName;
    private final MutableLiveData<String> profileInfo;
    private MutableLiveData<List<Rental>> rentalHistory;


    public ProfileViewModel() {
        clientName = new MutableLiveData<>();
        clientName.setValue("Nick");
        profileInfo = new MutableLiveData<>();
        profileInfo.setValue("First client!");
        loadRentalHistory();
    }

    private void loadRentalHistory() {
//        rentalHistory = new MutableLiveData<>(RentalController.getRentals(5L));
        ArrayList<Rental> tempRentalHistory = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tempRentalHistory.add(new Rental(new Timestamp(i * 100)));
        }
        rentalHistory = new MutableLiveData<>(tempRentalHistory);
    }

    public MutableLiveData<String> getClientName() {
        return clientName;
    }

    public MutableLiveData<String> getProfileInfo() {
        return profileInfo;
    }

    public MutableLiveData<List<Rental>> getRentalHistory() {
        return rentalHistory;
    }
}