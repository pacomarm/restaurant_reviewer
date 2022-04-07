package com.example.reviewer.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Reviewer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Review(reviewID TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

    }

    public Cursor getReviews(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reviewer", null);
        return cursor;
    }

    public Boolean insertReview(String restaurantName, Date date, int foodScore, int serviceScore, boolean recommended){
        return true;
    }

    public Boolean deleteReview(int reviewId){
        return true;
    }

    public Cursor getRestaurants(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reviewer", null);
        return cursor;
    }

    public Boolean insertRestaurant(String restaurantName, String owner, String cuisine, String city, String country){
        return true;
    }

    public Boolean deleteRestaurant(String restaurantName){
        return true;
    }

}
