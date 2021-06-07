package com.example.miskaa_task.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.miskaa_task.dao.CountryDao;
import com.example.miskaa_task.database.CountryDatabase;
import com.example.miskaa_task.modal.Country;

import java.util.List;

public class CountryRepository {

    private CountryDatabase countryDatabase;
    private CountryDao countryDao;
    private LiveData<List<Country>> getAllCountry;

    public CountryRepository(Application application){
        countryDatabase = CountryDatabase.getInstance(application);
        getAllCountry =  countryDatabase.countryDao().getAllCountries();
        countryDao = countryDatabase.countryDao();
    }

    public void insert(List<Country> countryList){
        new InsertAsyncTask(countryDatabase).execute(countryList);
    }
    public void delete(){
        new DeleteAsyncTask(countryDao).execute();
    }


    public LiveData<List<Country>> getGetAllCountry(){
        return getAllCountry;
    }

    static class InsertAsyncTask extends AsyncTask<List<Country> ,Void, Void> {

        private CountryDao countryDao;
        InsertAsyncTask(CountryDatabase countryDatabase){
            countryDao = countryDatabase.countryDao();
        }
        @Override
        protected Void doInBackground(List<Country>... lists) {
            countryDao.insert(lists[0]);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Void ,Void, Void> {

        private CountryDao countryDao;
        DeleteAsyncTask(CountryDao dao){
            this.countryDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            countryDao.deleteAll();
            return null;
        }
    }




}
