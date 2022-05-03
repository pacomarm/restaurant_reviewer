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

    DBHelper DB;
    Spinner restaurantsSelector;
    EditText foodScore, serviceScore, date, recommended;
    String restaurantName;
    Button addButton, cancel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_add_layout );
        //Initialize DB
        DB = new DBHelper(this);
        //Initialize Restaurants Spinner with Data
        restaurantsSelector = (Spinner) findViewById(R.id.restaurantSelector);
        ArrayList<String> restaurants = getRestaurants();
        restaurants.add(0, "Select One");
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, restaurants);
        restaurantsSelector.setAdapter(adapter);
        restaurantsSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                restaurantName = parent.getItemAtPosition(position).toString();
            }
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
        // listeners
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Boolean insertion = DB.insertReview(restaurantName, date.getText().toString(),
                        foodScore.getText().toString(), serviceScore.getText().toString(),
                        recommended.getText().toString());
                if(!insertion)
                    Toast.makeText(ReviewsAddController.this, "Error occurred :(", Toast.LENGTH_SHORT).show();
                else{
                    EditText[] arr = {foodScore, serviceScore, date, recommended};
                    clearFields(arr);
                    Toast.makeText(ReviewsAddController.this, "Review Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void clearFields(EditText[] arr){
        for(EditText text: arr){
            text.setText("");
        }
        restaurantName = "";
        restaurantsSelector.setSelection(0);
    }

    public void onClickRes(View view){
        if (view.getId() == R.id.button_revBack){
            Intent intent = new Intent(this, ReviewsController.class);
            startActivity(intent);
        }
    }

    public ArrayList<String> getRestaurants(){
        Cursor data = DB.getRestaurants();
        if(data.getCount()==0){
            Toast.makeText(ReviewsAddController.this, "No Restaurants Available", Toast.LENGTH_SHORT);
            return new ArrayList<String>();
        }
        //StringBuffer buffer = new StringBuffer();
        ArrayList list = new ArrayList();
        while(data.moveToNext()){
            /*
            buffer.append("Restaurant Name: " + data.getString(0) + "\n");
            buffer.append("Owner: " + data.getString(1) + "\n");
            buffer.append("Cuisine: " + data.getString(2) + "\n");
            buffer.append("City: " + data.getString(3) + "\n");
            buffer.append("Country: " + data.getString(4) + "\n\n");
            */
            list.add(data.getString(0));
        }
        return list;
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(ReviewsAddController.this);
        builder.setCancelable(true);
        builder.setTitle("Restaurants");
        builder.setMessage(buffer.toString());
        builder.show();
        */
    }

    public void goToReviews(View view){
        Intent intent = new Intent(this, ReviewsController.class);
        startActivity(intent);
    }

}
