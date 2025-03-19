package com.example.takeanumbrella.data.Client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientApiService {

    @GET("clients/{id}")
    Call<Client> getClientInfo(@Path("id") Long userId);

    @GET("clients/test")
    Call<ClientTestResponse> testClient(@Body Client client);

    @POST("clients/new")
    Call<Client> createClient(@Body Client client);
}
