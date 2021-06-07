package com.example.miskaa_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miskaa_task.adapters.CountryAdapter;
import com.example.miskaa_task.database.CountryDatabase;
import com.example.miskaa_task.modal.Country;
import com.example.miskaa_task.network.Api;
import com.example.miskaa_task.objects.CountryItem;
import com.example.miskaa_task.objects.CountryList;
import com.example.miskaa_task.repository.CountryRepository;
import com.example.miskaa_task.viewmodel.CountryViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CountryViewModel countryViewModal;
    private RecyclerView recyclerView;
    private List<Country> countryList;
    private CountryRepository countryRepository;
    private CountryAdapter  countryAdapter;
    private Button delete_countries;
    private static final String URL_DATA="https://restcountries.eu/rest/v2/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delete_countries = findViewById(R.id.countries_delete);
        recyclerView=findViewById(R.id.country_reclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        countryRepository=new CountryRepository(getApplication());
        countryList=new ArrayList<>();
        countryAdapter=new CountryAdapter(this,countryList);
        recyclerView.setAdapter(countryAdapter);
        networkRequest();
        countryViewModal = new ViewModelProvider(this).get(CountryViewModel.class);
        countryViewModal.getGetAllCountries().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {

                recyclerView.setAdapter(countryAdapter);
                countryAdapter.getAllCountries(countries);

            }
        });


        delete_countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             countryViewModal.delete();

            }
        });

    }

    public void networkRequest(){
        Retrofit retrofit = new  Retrofit.Builder().
                baseUrl(URL_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<CountryItem>> call = api.getAllCountry();

        call.enqueue(new Callback<List<CountryItem>>() {
            @Override
            public void onResponse(Call<List<CountryItem>> call, Response<List<CountryItem>> response) {
                if(response.isSuccessful()){

                    List<CountryItem> list = response.body();
                    List<Country> ctn = new ArrayList<>();
                    for (CountryItem n : list){
                        ctn.add(new Country(n.getName(),n.getCapital(),n.getFlag(),n.getRegion(),n.getSubregion(),n.getPopulation(),n.getBorders(),n.getLanguages()));
                    }
                    countryRepository.insert(ctn);

                }
            }

            @Override
            public void onFailure(Call<List<CountryItem>> call, Throwable t) {


            }
        });
    }
}