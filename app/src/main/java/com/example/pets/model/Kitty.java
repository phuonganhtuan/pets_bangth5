package com.example.pets.model;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Kitty {

    private int resourceImage;///
    private String id;
    private String name;
    private String temperament;
    private String life_span;
    private String alt_names;
    private String wikipedia_url;
    private String origin;
    private String weight_imperial;
    private int experimental;
    private int hairless;
    private int hypoallergenic;
    private int natural;
    private int rare;
    private int rex;
    private int short_legs;
    private int suppressed_tail;

    private Photo image;

    public Photo getImage() {
        return image;
    }

    public void setImage(Photo image) {
        this.image = image;
    }

    //
    private static Kitty getKitties (JSONObject jsonObject){
        return new Gson().fromJson(jsonObject.toString(),Kitty.class);
    }

    public  static ArrayList<Kitty> getAllKitties(JSONArray jsonArray) throws JSONException {
        ArrayList<Kitty> arrayList = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++) {
            arrayList.add(getKitties(jsonArray.getJSONObject(i)));
        }
        return arrayList;
    }
    //

    public Kitty(int resourceImage, String id, String name, String temperament, String life_span, String alt_names, String wikipedia_url, String origin, String weight_imperial, int experimental, int hairless, int hypoallergenic, int natural, int rare, int rex, int short_legs, int suppressed_tail) {
        this.resourceImage = resourceImage;
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.life_span = life_span;
        this.alt_names = alt_names;
        this.wikipedia_url = wikipedia_url;
        this.origin = origin;
        this.weight_imperial = weight_imperial;
        this.experimental = experimental;
        this.hairless = hairless;
        this.hypoallergenic = hypoallergenic;
        this.natural = natural;
        this.rare = rare;
        this.rex = rex;
        this.short_legs = short_legs;
        this.suppressed_tail = suppressed_tail;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public void setWeight_imperial(String weight_imperial) {
        this.weight_imperial = weight_imperial;
    }

    public int getExperimental() {
        return experimental;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(int hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getRex() {
        return rex;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public int getShort_legs() {
        return short_legs;
    }

    public void setShort_legs(int short_legs) {
        this.short_legs = short_legs;
    }

    public int getSuppressed_tail() {
        return suppressed_tail;
    }

    public void setSuppressed_tail(int suppressed_tail) {
        this.suppressed_tail = suppressed_tail;
    }

    /*
    public Kitty(int resourceImage, String id, String name, String temperament, String life_span, String alt_names, String wikipedia_url, String origin, String weight_imperial) {
        this.resourceImage = resourceImage;
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.life_span = life_span;
        this.alt_names = alt_names;
        this.wikipedia_url = wikipedia_url;
        this.origin = origin;
        this.weight_imperial = weight_imperial;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public void setWeight_imperial(String weight_imperial) {
        this.weight_imperial = weight_imperial;
    }

     */
}
