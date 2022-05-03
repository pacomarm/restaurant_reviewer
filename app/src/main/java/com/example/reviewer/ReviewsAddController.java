package com.example.reviewer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.reviewer.Model.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAddController extends Activity {

    // Defining the attributes of the class
    DBHelper DB;
    Spinner restaurantsSelector; // restaurant selector attribute
    EditText foodScore, serviceScore, date, recommended; // EditText attributes of the TextFields in the Add Review View
    String restaurantName;
    Button addButton, cancel; // Definition of the buttons on the view

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_add_layout );
        //Initialize DB
        DB = new DBHelper(this);
        //Initialize Restaurants Spinner with Data
        restaurantsSelector = (Spinner) findViewById(R.id.restaurantSelector);
        ArrayList<String> restaurants = getRestaurants();
        restaurants.add(0, "Select One");
        // Setting styles of the restaurant Selector
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, restaurants);
        restaurantsSelector.setAdapter(adapter);
        // Listener to listen to selection of restaurant
        restaurantsSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            // Method to trigger when a restaurant is selected
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                restaurantName = parent.getItemAtPosition(position).toString();
            }
            // Method to trigger when nothing happens
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        //Initialize buttons
        addButton = findViewById(R.id.addReview);
        // Initialization text fields
        foodScore = findViewById(R.id.foodScore);
        serviceScore = findViewById(R.id.serviceScore);
        date = findViewById(R.id.date);
        recommended = findViewById(R.id.recommended);
        // defining listener to addButton
        addButton.setOnClickListener(new View.OnClickListener(){
            // On click Method to add a review
            @Override
            public void onClick(View view){
                Boolean insertion = DB.insertReview(restaurantName, date.getText().toString(),
                        foodScore.getText().toString(), serviceScore.getText().toString(),
                        recommended.getText().toString());
                if(!insertion) // If error occurred inserting
                    Toast.makeText(ReviewsAddController.this, "Error occurred :(", Toast.LENGTH_LONG).show();
                else{ // if successful
                    EditText[] arr = {foodScore, serviceScore, date, recommended};
                    clearFields(arr);
                    AlertDialog.Builder builder = new AlertDialog.Builder(ReviewsAddController.this);
                    builder.setCancelable(true);
                    builder.setTitle("Success");
                    builder.setMessage("Review Added");
                    builder.show();
                }
            }
        });
    }

    // Clear all fields on the View
    public void clearFields(EditText[] arr){
        for(EditText text: arr){
            text.setText("");
        }
        restaurantName = "";
        restaurantsSelector.setSelection(0);
    }

    // Method to get the restaurants from the DBHelper class
    // You will get an array list of strings, just with name of restaurant
    public ArrayList<String> getRestaurants(){
        Cursor data = DB.getRestaurants();
        if(data.getCount()==0){
            Toast.makeText(ReviewsAddController.this, "No Restaurants Available", Toast.LENGTH_LONG);
            return new ArrayList<String>();
        }
        ArrayList list = new ArrayList();
        while(data.moveToNext()){
            list.add(data.getString(0));
        }
        return list;
    }

    // Method to go to the Reviews view
    public void goToReviews(View view){
        Intent intent = new Intent(this, ReviewsController.class);
        startActivity(intent);
    }

}
