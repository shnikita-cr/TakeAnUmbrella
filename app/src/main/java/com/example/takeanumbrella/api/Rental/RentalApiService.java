package com.example.takeanumbrella.api.Rental;

import com.example.takeanumbrella.data.Rental.Rental;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RentalApiService {
    @GET("rentals/{id}")
    Call<Rental> getRentalInfo(@Path("id") Long rentalId);

    @GET("rentals/{clientId}")
    Call<List<Rental>> getClientRentalInfo(@Path("clientId") Long clientId);

    @POST("rental")
    Call<Rental> newRental(@Body Rental rental);
}

