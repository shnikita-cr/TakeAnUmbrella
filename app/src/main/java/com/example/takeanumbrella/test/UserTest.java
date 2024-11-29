package com.example.takeanumbrella.test;

import android.util.Log;

import com.example.takeanumbrella.api.ApiService;
import com.example.takeanumbrella.data.Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserTest {
    final String BASE_URL = "http://192.168.45.35:8080/api/v1/";
    public void test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<Client> userCall = service.getUser(5L);
        userCall.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response.isSuccessful()) {
                    Client client = response.body();
                    Log.i("UserResponseSuccess", client.toString());
                } else {
                    // Обработка ошибки
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("UserResponseFailure", t.toString());
            }
        });
    }
}
