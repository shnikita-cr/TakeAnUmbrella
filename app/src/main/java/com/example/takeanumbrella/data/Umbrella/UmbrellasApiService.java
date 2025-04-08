package com.example.takeanumbrella.data.Umbrella;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UmbrellasApiService {
    @GET("umbrellas/{placeId}")
    Call<List<Umbrella>> getRentalInfo(@Path("placeId") Long placeId);
}
