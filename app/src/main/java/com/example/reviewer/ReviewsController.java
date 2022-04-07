package com.example.reviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ReviewsController extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_layout);
    }

    public void goAddReview(View view){
        Intent intent = new Intent(this, ReviewsAddController.class);
        startActivity(intent);
    }

    public List<String> getReviews(){
        return new ArrayList<>();
    }

    public void deleteReview(View view){

    }

    public void goHome(View view){

    }

}
