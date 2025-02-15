package com.example.takeanumbrella.data.Client;

import android.util.Log;

import com.example.takeanumbrella.api.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClientController {
    public static Client getClientInfo(Long clientId) {
        Retrofit retrofit = RetrofitClient.getInstance();

        ClientApiService service = retrofit.create(ClientApiService.class);

        Call<Client> clientCall = service.getClientInfo(clientId);
        clientCall.enqueue(new ClientCallback());

        try {
            return clientCall.execute().body();
        } catch (IOException e) {
            Log.e("clientCall IOException", e.toString());
        }
        return new Client();
    }

    public static Client createUser(Client client) {
        Retrofit retrofit = RetrofitClient.getInstance();

        ClientApiService service = retrofit.create(ClientApiService.class);

        Call<Client> clientCall = service.createClient(client);
        clientCall.enqueue(new ClientCallback());

        try {
            return clientCall.execute().body();
        } catch (IOException e) {
            Log.e("clientCall IOException", e.toString());
        }
        return new Client();
    }

    public static ClientTestResponse testClient(Client client) {
        Retrofit retrofit = RetrofitClient.getInstance();

        ClientApiService service = retrofit.create(ClientApiService.class);

        Call<ClientTestResponse> clientCall = service.testClient(client);
        clientCall.enqueue(new ClientTestResponseCallback());

        try {
            return clientCall.execute().body();
        } catch (IOException e) {
            Log.e("clientCall IOException", e.toString());
        }
        return new ClientTestResponse();
    }

    private static class ClientCallback implements Callback<Client> {
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
    }

    private static class ClientTestResponseCallback implements Callback<ClientTestResponse> {
        @Override
        public void onResponse(Call<ClientTestResponse> call, Response<ClientTestResponse> response) {
            if (response.isSuccessful()) {
                ClientTestResponse client = response.body();
                Log.i("UserResponseSuccess", client.toString());
            } else {
                // Обработка ошибки
            }
        }

        @Override
        public void onFailure(Call<ClientTestResponse> call, Throwable t) {
            Log.e("UserResponseFailure", t.toString());
        }
    }
}