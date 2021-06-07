package com.example.miskaa_task.objects;



import java.util.List;

public class CountryItem {

    private  String alpha2Code;

    private  String alpha3Code;

    private  List altSpellings;
    private  double area;

    private  List borders;

    private  List callingCodes;

    private  String capital;

    private  String cioc;

    private  List currencies;

    private  String demonym;

    private  String flag;
    private  double gini;

    private  List languages;

    private  List latlng;

    private  String name;

    private  String nativeName;

    private  String numericCode;
    private  int population;

    private  String region;

    private  List regionalBlocs;

    private  String subregion;

    private  List timezones;

    private  List topLevelDomain;

    private Translation translations;

    public CountryItem(String alpha2Code, String alpha3Code, List altSpellings, double area, List borders, List callingCodes, String capital, String cioc, List currencies, String demonym, String flag, double gini, List languages, List latlng, String name, String nativeName, String numericCode, int population, String region, List regionalBlocs, String subregion, List timezones, List topLevelDomain, Translation translations) {
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.altSpellings = altSpellings;
        this.area = area;
        this.borders = borders;
        this.callingCodes = callingCodes;
        this.capital = capital;
        this.cioc = cioc;
        this.currencies = currencies;
        this.demonym = demonym;
        this.flag = flag;
        this.gini = gini;
        this.languages = languages;
        this.latlng = latlng;
        this.name = name;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.population = population;
        this.region = region;
        this.regionalBlocs = regionalBlocs;
        this.subregion = subregion;
        this.timezones = timezones;
        this.topLevelDomain = topLevelDomain;
        this.translations = translations;
    }


    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List altSpellings) {
        this.altSpellings = altSpellings;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List getBorders() {
        return borders;
    }

    public void setBorders(List borders) {
        this.borders = borders;
    }

    public List getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public List getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List currencies) {
        this.currencies = currencies;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public List getLanguages() {
        return languages;
    }

    public void setLanguages(List languages) {
        this.languages = languages;
    }

    public List getLatlng() {
        return latlng;
    }

    public void setLatlng(List latlng) {
        this.latlng = latlng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public List getTimezones() {
        return timezones;
    }

    public void setTimezones(List timezones) {
        this.timezones = timezones;
    }

    public List getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public Translation getTranslations() {
        return translations;
    }

    public void setTranslations(Translation translations) {
        this.translations = translations;
    }
}
