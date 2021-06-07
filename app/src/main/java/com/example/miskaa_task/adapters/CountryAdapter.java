package com.example.miskaa_task.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.miskaa_task.R;
import com.example.miskaa_task.modal.Country;
import com.pixplicity.sharp.Sharp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {


    private Context context;
    private List<Country> countryList;
    private static OkHttpClient httpClient;

    public CountryAdapter(Context context,List<Country> countries ){
        this.countryList = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_layout,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull  CountryAdapter.CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.name.setText("Name: " + country.getName());
        holder.capital.setText("Capital: " + country.getCapital());
        holder.region.setText("Region: " + country.getRegion());
        holder.sub_region.setText("Sub-Region: "+ country.getSubregion());
        holder.borders.setText("Borders: " + country.getBorders().toString());
        holder.languages.setText("languages: " + country.getLanguages().toString());
        holder.population.setText("Population: "+ country.getPopulation());
        fetchSvg(context,country.getFlag(),holder.country_image);



    }

    public void getAllCountries(List<Country> countries){
        this.countryList = countries;
    }

    @Override
    public int getItemCount() {
        if(countryList != null) {
            return countryList.size();
        }

        return 0;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        public TextView capital,region,name,sub_region, languages, borders,population;
        public  ImageView country_image;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.country_name);
            region = itemView.findViewById(R.id.country_region);
            sub_region = itemView.findViewById(R.id.country_subregion);
            capital = itemView.findViewById(R.id.country_capital);
            country_image = itemView.findViewById(R.id.country_image);
            languages = itemView.findViewById(R.id.country_languages);
            borders  = itemView.findViewById(R.id.country_borders);
            population = itemView.findViewById(R.id.country_population);

        }
    }

    public static void fetchSvg(Context context, String url, final ImageView target) {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .cache(new Cache(context.getCacheDir(), 5 * 1024 * 1014))
                    .build();
        }

        // here we are making HTTP call to fetch data from URL.
        Request request = new Request.Builder().url(url).build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // we are adding a default image if we gets any error.

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // sharp is a library which will load stream which we generated
                // from url in our target imageview.
                InputStream stream = response.body().byteStream();
                Sharp.loadInputStream(stream).into(target);
                stream.close();
            }
        });
    }

}
