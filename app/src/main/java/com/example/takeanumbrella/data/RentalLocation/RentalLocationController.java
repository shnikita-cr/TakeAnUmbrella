package com.example.takeanumbrella.data.RentalLocation;

import android.util.Log;

import com.example.takeanumbrella.api.RetrofitClient;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RentalLocationController {
    public static List<RentalLocation> getRentalLocationsSync() {
        return RentalLocationController.getRentalLocationsSync("");
    }

    public static List<RentalLocation> getRentalLocationsSync(String searchQuery) {
        Retrofit retrofit = RetrofitClient.getInstance();
        RentalLocationApiService service = retrofit.create(RentalLocationApiService.class);

        Call<List<RentalLocation>> rentalLocationCall = service.getQueryLocations(searchQuery);
        try {
            Response<List<RentalLocation>> response = rentalLocationCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
        } catch (IOException e) {
            Log.e("RentalLocationCall", e.toString());
        }
        return Collections.emptyList();
    }
}

