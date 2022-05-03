package com.example.reviewer.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    // Constructor of the DBHelper class.
    public DBHelper(Context context) {
        super(context, "Reviewer.db", null, 1);
    }

    // Overriding the onCreate method, where we create the Restaurants and Reviews tables.
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Restaurants(restaurantName TEXT primary key, owner TEXT, cuisine TEXT, city TEXT, country TEXT)");
        DB.execSQL("Create Table Reviews(reviewId TEXT primary key, restaurantName TEXT, date TEXT, foodScore TEXT, serviceScore TEXT, recommended TEXT)");
    }

    // Overriding the onUpgrade method, if the stored database must be updated, thus it is dropped
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Restaurants");
        DB.execSQL("drop Table if exists Reviews");
    }

    // Method to get all of the reviews in the Reviews table
    public Cursor getReviews(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reviews", null);
        return cursor;
    }

    // Method to Insert a review to the Reviews table
    public Boolean insertReview(String restaurantName, String date, String foodScore, String serviceScore, String recommended){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("reviewId", Integer.toString(new Date().hashCode()));
        values.put("restaurantName", restaurantName);
        values.put("date", date);
        values.put("foodScore", foodScore);
        values.put("serviceScore", serviceScore);
        values.put("recommended", recommended);
        System.out.println(values);
        long result = DB.insert("Reviews", null, values);
        if(result==-1)
            return false;
        return true;
    }

    // Method to get all restaurants in the Restaurants table
    public Cursor getRestaurants(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Restaurants", null);
        return cursor;
    }

    // Method to insert a restaurant to the Restaurants Table
    public Boolean insertRestaurant(String restaurantName, String owner, String cuisine, String city, String country){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("restaurantName", restaurantName);
        values.put("owner", owner);
        values.put("cuisine", cuisine);
        values.put("city", city);
        values.put("country", country);
        long result = DB.insert("Restaurants", null, values);
        if(result==-1)
            return false;
        return true;
    }
}
