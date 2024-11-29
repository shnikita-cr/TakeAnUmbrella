package com.example.takeanumbrella.api.Client;

import com.example.takeanumbrella.data.Client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientApiService {//todo нужно ли несколько разных интерфейсов для зонтиков, пользователей и тд

    @GET("clients/{id}")
    Call<Client> getUser(@Path("id") Long userId);

    @POST("clients")
    Call<Client> createUser(@Body Client client);
}
