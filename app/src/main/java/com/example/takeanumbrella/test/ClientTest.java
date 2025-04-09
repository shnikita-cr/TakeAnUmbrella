package com.example.takeanumbrella.test;

import static com.example.takeanumbrella.api.ApiConfiguration.BASE_URL;

import android.util.Log;

import com.example.takeanumbrella.data.Client.Client;
import com.example.takeanumbrella.data.Client.ClientApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientTest {
    public void test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClientApiService service = retrofit.create(ClientApiService.class);

        Call<Client> userCall = service.getClientInfo(5L);
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
