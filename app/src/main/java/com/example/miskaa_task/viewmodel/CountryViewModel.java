package com.example.miskaa_task.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miskaa_task.modal.Country;
import com.example.miskaa_task.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {
    private CountryRepository countryRepository;
    private LiveData<List<Country>> getAllCountries;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        getAllCountries = countryRepository.getGetAllCountry();
    }

    public void insert(List<Country> list){
       countryRepository.insert(list); }
    public void delete (){
        countryRepository.delete();
    }


    public LiveData<List<Country>>  getGetAllCountries(){
        return  getAllCountries;
    }
}
