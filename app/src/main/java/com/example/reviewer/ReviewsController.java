package com.example.reviewer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewer.Model.DBHelper;
import com.example.reviewer.Model.Review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReviewsController extends Activity {

    DBHelper DB;
    ArrayList<Review> listReviews;
    RecyclerView recycler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.reviews_layout);
        DB = new DBHelper(this);
        // Initialize recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listReviews = new ArrayList<>();
        //
        try {
            listReviews = getReviews();
            ReviewsAdapter adapter = new ReviewsAdapter(listReviews);
            recycler.setAdapter(adapter);
        } catch (ParseException e) {
            Toast.makeText(ReviewsController.this,"Error getting Reviews", Toast.LENGTH_SHORT).show();
        }
    }

    public void goAddReview(View view){
        Intent intent = new Intent(this, ReviewsAddController.class);
        startActivity(intent);
    }

    public ArrayList<Review> getReviews() throws ParseException {
        Cursor data = DB.getReviews();
        if(data.getCount()==0){
            Toast.makeText(ReviewsController.this,"No Reviews Available", Toast.LENGTH_SHORT).show();
            return new ArrayList<Review>();
        }
        ArrayList<Review> list = new ArrayList<>();
        while(data.moveToNext()){
            list.add(new Review(data.getString(0), data.getString(1),
                    new SimpleDateFormat("MM/dd/yy").parse(data.getString(2)),
                    Integer.parseInt(data.getString(3)), Integer.parseInt(data.getString(4)),
                    data.getString(5).equals("Recommended")));
        }
        /*
        for(Review r: list){
            System.out.println(r.getReviewId()+ " "+ r.getRestaurantName()+r.isRecommended());
        }*/
        return list;
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
