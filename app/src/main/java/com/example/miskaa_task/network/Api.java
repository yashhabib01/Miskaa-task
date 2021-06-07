package com.example.miskaa_task.network;

import com.example.miskaa_task.objects.CountryItem;
import com.example.miskaa_task.objects.CountryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("region/asia")
    Call<List<CountryItem>>  getAllCountry();

}
