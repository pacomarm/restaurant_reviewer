package com.example.reviewer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.reviewer.Model.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAddController extends Activity {

    DBHelper DB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_add_layout );
        DB = new DBHelper(this);
        getRestaurants();
    }

    public void onClickRes(View view){
        if (view.getId() == R.id.button_revBack){
            Intent intent = new Intent(this, ReviewsController.class);
            startActivity(intent);
        }
    }

    public void getRestaurants(){
        Cursor data = DB.getRestaurants();
        if(data.getCount()==0){
            Toast.makeText(ReviewsAddController.this, "No Restaurants Available", Toast.LENGTH_SHORT);
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append("Restaurant Name: " + data.getString(0) + "\n");
            buffer.append("Owner: " + data.getString(1) + "\n");
            buffer.append("Cuisine: " + data.getString(2) + "\n");
            buffer.append("City: " + data.getString(3) + "\n");
            buffer.append("Country: " + data.getString(4) + "\n\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(ReviewsAddController.this);
        builder.setCancelable(true);
        builder.setTitle("Restaurants");
        builder.setMessage(buffer.toString());
        builder.show();
    }

    public void addReview(View view){

    }

    public void goToReviews(View view){

    }

}
