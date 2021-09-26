package com.example.pets.api;

import com.example.pets.model.Kitty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1/breeds")
    Call<ArrayList<Kitty>> getListKitties (@Query("attach_breed") int attach_breed,
                                           @Query("page") int page,
                                           @Query("limit") int limit);
}
