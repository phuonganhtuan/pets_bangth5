package com.example.pets.model;

public class Kitty {

    private int resourceImage;
    private String id;
    private String name;
    private String temperament;
    private String life_span;
    private String alt_names;
    private String wikipedia_url;
    private String origin;
    private String weight_imperial;

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
}
