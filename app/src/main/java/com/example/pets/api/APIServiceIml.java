package com.example.pets.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.pets.MainActivity;
import com.example.pets.listener.FectDataCallBack;
import com.example.pets.model.Kitty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class APIServiceIml {
    String TAG = APIServiceIml.class.getSimpleName();
    private static ApiService apiService;
    private static ApiService getApiService() {
        if (apiService == null) {
            Gson gson = new GsonBuilder().create();
            apiService  = new Retrofit.Builder()
                    .baseUrl("https://api.thecatapi.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiService.class);
        }
        return apiService;
    }

    public static void getAllKitties(int page, final FectDataCallBack dataCallback) {
//        apiService = ApiService.apiService.create(ApiService.class);
        Call<ArrayList<Kitty>> getProduct = getApiService().getListKitties(0,page,10 );
        getProduct.enqueue(new Callback<ArrayList<Kitty>>() {
            @Override
            public void onResponse(Call<ArrayList<Kitty>> call, Response<ArrayList<Kitty>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Kitty> kitties = response.body();
                    dataCallback.onFetchSuccess(kitties);
                } else {
//                    Toast.makeText(Context, "fail!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Kitty>> call, Throwable t) {
//                Toast.makeText(Context, "fail!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
