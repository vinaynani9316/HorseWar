package com.accenture.horse1.model;

public class Item
{

    private String name;

    private int image_name;

    private String breed_name;

    private float rating;

    public  Item(String name, int image_name, String breed_name, float rating ) {
        this.name = name;
        this.image_name = image_name;
        this.breed_name= breed_name;
        this.rating= rating;
    }

    public String getName() {
        return name;
    }

    public int getImageName() {
        return image_name;
    }

    public String getBreed_name() { return breed_name;}

    public float getRating() { return rating;}

}

