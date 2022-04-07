package com.example.reviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAddController extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_add_layout );
    }

    public void onClickRes(View view){
        if (view.getId() == R.id.button_revBack){
            Intent intent = new Intent(this, ReviewsController.class);
            startActivity(intent);
        }
    }

    public List<String> getRestaurants(){
        return new ArrayList<>();
    }

    public void addReview(View view){

    }

    public void goToReviews(View view){

    }

}
