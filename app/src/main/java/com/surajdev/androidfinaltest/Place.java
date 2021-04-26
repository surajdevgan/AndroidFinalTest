package com.surajdev.androidfinaltest;

import java.util.ArrayList;

public class Place {
    private String name;
    private String countryName;
    private int price;
    private ArrayList<String> images;

    public Place(String name, String countryName, int price, ArrayList<String> images) {
        this.name = name;
        this.countryName = countryName;
        this.price = price;
        this.images = images;
    }

    public Place(String name, String countryName, int price) {
        this.name = name;
        this.countryName = countryName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}

