package com.example.takeanumbrella.data.RentalLocation;

import android.util.Log;

import com.example.takeanumbrella.api.RetrofitClient;


import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RentalLocationController {
    public static List<RentalLocation> getRentalLocations() {
        return getRentalLocations("");
    }

    public static List<RentalLocation> getRentalLocations(String searchQuery) {

        Retrofit retrofit = RetrofitClient.getInstance();

        RentalLocationApiService service = retrofit.create(RentalLocationApiService.class);

        Call<List<RentalLocation>> rentalLocationCall = service.getCityLocations(searchQuery);
        rentalLocationCall.enqueue(new Callback<List<RentalLocation>>() {
            @Override
            public void onResponse(Call<List<RentalLocation>> call, Response<List<RentalLocation>> response) {
                if (response.isSuccessful()) {
                    List<RentalLocation> rental = response.body();
                    Log.i("UserResponseSuccess", rental.get(0).toString());
                } else {
                    // Обработка ошибки
                }
            }

            @Override
            public void onFailure(Call<List<RentalLocation>> call, Throwable t) {
                Log.e("UserResponseFailure", t.toString());
            }
        });

        try {
            return rentalLocationCall.execute().body();
        } catch (IOException e) {
            Log.e("RentalLocationCall IOException", e.toString());
        }
        return java.util.Collections.emptyList();
    }
}

