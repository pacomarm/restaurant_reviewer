package com.example.reviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RestaurantsController extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.restaurants_layout );
    }

    /*public void onClickRes(View view){
        if (view.getId() == R.id.button_revBack){
            Intent intent = new Intent(this, ReviewsActivity.class);
            startActivity(intent);
        }
    }*/

    public void addRestaurant(View view){

    }

    public void goHome(View view){

    }

}
