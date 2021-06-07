package com.example.miskaa_task.objects;

import java.util.List;

public class CountryList {

    public List<CountryItem> countryItems;

    public CountryList(List<CountryItem> countryItems) {
        this.countryItems = countryItems;
    }

    public List<CountryItem> getCountryItems() {
        return countryItems;
    }

    public void setCountryItems(List<CountryItem> countryItems) {
        this.countryItems = countryItems;
    }
}
