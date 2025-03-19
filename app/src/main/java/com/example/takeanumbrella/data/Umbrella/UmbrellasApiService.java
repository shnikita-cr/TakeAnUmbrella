package com.example.takeanumbrella.data.Umbrella;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UmbrellasApiService {
    @GET("umbrellas/{placeId}")
    Call<Umbrella> getRentalInfo(@Path("placeId") Long placeId);
}
