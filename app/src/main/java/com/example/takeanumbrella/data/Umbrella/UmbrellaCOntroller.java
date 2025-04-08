package com.example.takeanumbrella.data.Umbrella;

import android.util.Log;

import com.example.takeanumbrella.api.RetrofitClient;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UmbrellaCOntroller {
    public static List<Umbrella> getRentalInfo(Long placeID){
        Retrofit retrofit = RetrofitClient.getInstance();
        UmbrellasApiService service = retrofit.create(UmbrellasApiService.class);

        Call<List<Umbrella>> umbrellaCall = service.getRentalInfo(placeID);
        umbrellaCall.enqueue(new Callback<List<Umbrella>>() {
            @Override
            public void onResponse(Call<List<Umbrella>> call, Response<List<Umbrella>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Umbrella> umbrellas = response.body();
                    Log.d("API_SUCCESS", "Quantity of umbrellas: " + umbrellas.size());
                } else {
                    Log.e("API_ERROR", "Error message: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Umbrella>> call, Throwable t) {
                Log.e("UserResponseFailure", t.toString());
            }
        });

        try {
            return umbrellaCall.execute().body();
        } catch (IOException e) {
            Log.e("rentalCall IOException", e.toString());
//            throw new RuntimeException(e);
        }
        return java.util.Collections.emptyList();
    }
}
