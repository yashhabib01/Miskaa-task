package com.example.miskaa_task.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.miskaa_task.modal.Country;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert()
    void insert(List<Country> countryList);

    @Query("SELECT * FROM countries")
    LiveData<List<Country>> getAllCountries();

    @Query("DELETE FROM countries")
    void deleteAll();
}
