package com.example.miskaa_task.modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "countries")
public class Country {

    @PrimaryKey(autoGenerate = true)
    private int countryId;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private  String name;

    @SerializedName("capital")
    @ColumnInfo(name = "capital")
    private String capital;

    @SerializedName("flag")
    @ColumnInfo(name = "flag")
    private String flag;

    @SerializedName("region")
    @ColumnInfo(name = "region")
    private String region;

    @SerializedName("subregion")
    @ColumnInfo(name = "subregion")
    private String subregion;

    @SerializedName("population")
    @ColumnInfo(name = "population")
    private int population;

    @SerializedName("borders")
    @ColumnInfo(name = "borders")
    private List<String> borders;

    @SerializedName("languages")
    @ColumnInfo(name = "languages")
    private List<Languages> languages;



    public static class Converters{
        @TypeConverter
        public String borderListToString(List<String> borders){
            if(borders == null){
                return null;
            }
            Gson gson  = new Gson();
            Type type = new TypeToken<List<String>>() {}.getType();
            String json = gson.toJson(borders,type);
            return json;
        }
        @TypeConverter
        public List<String> borderStringToList(String borderLangString){
            if(borderLangString == null){
                return null;
            }
            Gson gson = new Gson();
            Type type = new TypeToken<List<String>>() {}.getType();
            List<String> border = gson.fromJson(borderLangString,type);
            return border;
        }
        @TypeConverter
        public String listToString(List<Languages> languages){
            if(languages == null){
                return null;
            }
            Gson gson = new Gson();
            Type type = new   TypeToken<List<Languages>>() {}.getType();
            String json = gson.toJson(languages,type);
            return json;
        }

        @TypeConverter
        public List<Languages> StringToList(String languageLangString){
            if(languageLangString == null){
                return null;
            }

            Gson gson = new Gson();
            Type type = new TypeToken<List<Languages>>(){}.getType();
            List<Languages> list = gson.fromJson(languageLangString,type);
            return list;
        }


    }




    public Country( String name, String capital, String flag, String region, String subregion, int population,List<String> borders , List<Languages> languages) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
        this.languages = languages;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String>  borders) {
        this.borders = borders;
    }

    public List<Languages>  getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages>  languages) {
        this.languages = languages;
    }

}
