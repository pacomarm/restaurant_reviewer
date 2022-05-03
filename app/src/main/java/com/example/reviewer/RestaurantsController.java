package com.example.reviewer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reviewer.Model.DBHelper;

public class RestaurantsController extends Activity {

    EditText name, owner, cuisine, city, country;
    DBHelper DB;
    Button insert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.restaurants_layout );
        //initializing text fields
        name = findViewById(R.id.name);
        owner = findViewById(R.id.owner);
        cuisine = findViewById(R.id.cuisine);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        //Initializing buttons
        insert = findViewById(R.id.insertButton);
        //Initializing DB
        DB = new DBHelper(this);
        //Listeners
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean insertion = DB.insertRestaurant(name.getText().toString(),
                        owner.getText().toString(), cuisine.getText().toString(),
                        city.getText().toString(), country.getText().toString());
                if(insertion){
                    EditText[] arr = {name, owner, cuisine, city, country};
                    clearFields( arr);
                    AlertDialog.Builder builder = new AlertDialog.Builder(RestaurantsController.this);
                    builder.setCancelable(true);
                    builder.setTitle("Success");
                    builder.setMessage("Restaurant Added");
                    builder.show();
                    //Toast.makeText(RestaurantsController.this, "Restaurant Added", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RestaurantsController.this, "Error occurred :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*public void onClickRes(View view){
        if (view.getId() == R.id.button_revBack){
            Intent intent = new Intent(this, ReviewsActivity.class);
            startActivity(intent);
        }
    }*/

    public void clearFields(EditText[] arr){
        for(EditText text : arr){
            text.setText("");
        }
    }

    public void addRestaurant(){
        Boolean insertion = DB.insertRestaurant(name.getText().toString(),
                owner.getText().toString(), cuisine.getText().toString(),
                city.getText().toString(), country.getText().toString());
        if(insertion){
            AlertDialog.Builder builder = new AlertDialog.Builder(RestaurantsController.this);
            builder.setCancelable(true);
            builder.setTitle("Success");
            builder.setMessage("Restaurant Added");
            builder.show();
            //Toast.makeText(RestaurantsController.this, "Restaurant Added", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(RestaurantsController.this, "Error occurred :(", Toast.LENGTH_SHORT).show();
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
