package com.example.reviewer.Model;

import java.util.Date;

public class Review {

    // Defining the attributes of a Review Object
    private String reviewId, restaurantName;
    private Date date;
    private int foodScore, serviceScore;
    private boolean recommended;

    // Constructor of the Review class
    public Review(String reviewId, String restaurantName, Date date, int foodScore, int serviceScore, boolean recommended) {
        this.reviewId = reviewId;
        this.restaurantName = restaurantName;
        this.date = date;
        this.foodScore = foodScore;
        this.serviceScore = serviceScore;
        this.recommended = recommended;
    }

    // Setters and getters of the Review attributes
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFoodScore() {
        return foodScore;
    }

    public void setFoodScore(int foodScore) {
        this.foodScore = foodScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }
    // end of setters and getters
}
