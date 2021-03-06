package com.example.reviewer.Model;

public class Restaurant {

    // Defining the attributes of a Restaurant Object
    private String restaurantName;
    private String owner;
    private String cuisine;
    private String city;
    private String country;

    // Constructor of the restaurant class
    public Restaurant(String restaurantName, String owner, String cuisine, String city, String country) {
        this.restaurantName = restaurantName;
        this.owner = owner;
        this.cuisine = cuisine;
        this.city = city;
        this.country = country;
    }

    // Setters ang getters of all attributes of a restaurant Object
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    // End setters and getters
}
