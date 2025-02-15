package com.example.takeanumbrella.data.RentalLocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RentalLocationApiService {
    @GET("locations/{searchQuery}")
    Call<List<RentalLocation>> getQueryLocations(@Path("searchQuery") String searchQuery);
}