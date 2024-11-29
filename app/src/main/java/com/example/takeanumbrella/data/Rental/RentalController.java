package com.example.takeanumbrella.data.Rental;

import android.util.Log;

import com.example.takeanumbrella.api.RetrofitClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RentalController {
    public static List<Rental> getRentals(Long clientId) {
        Retrofit retrofit = RetrofitClient.getInstance();

        RentalApiService service = retrofit.create(RentalApiService.class);

        Call<List<Rental>> rentalCall = service.getClientRentalInfo(clientId);
        rentalCall.enqueue(new Callback<List<Rental>>() {
            @Override
            public void onResponse(Call<List<Rental>> call, Response<List<Rental>> response) {
                if (response.isSuccessful()) {
                    List<Rental> rental = response.body();
                    Log.i("UserResponseSuccess", rental.get(0).toString());
                } else {
                    // Обработка ошибки
                }
            }

            @Override
            public void onFailure(Call<List<Rental>> call, Throwable t) {
                Log.e("UserResponseFailure", t.toString());
            }
        });

        try {
            return rentalCall.execute().body();
        } catch (IOException e) {
            Log.e("rentalCall IOException", e.toString());
//            throw new RuntimeException(e);
        }
        return java.util.Collections.emptyList();
    }
}
