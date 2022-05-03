package com.example.reviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewer.Model.Review;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    // This is an adapter Class used for the Recycler View component, which will show the
    // list of reviews.

    // Defining arraylist of reviews
    ArrayList<Review> listReviews;

    // Constructor to the class
    public ReviewsAdapter(ArrayList<Review> listReviews) {
        this.listReviews = listReviews;
    }

    // Method to create a ReviewViewHolder for each review
    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ReviewViewHolder(view);
    }

    // Method to set the appropriate data of each review to its corresponding
    // ReviewViewHolder
    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.setReviewData(listReviews.get(position));
    }

    // Method to get the amount of reviews
    @Override
    public int getItemCount() {
        return listReviews.size();
    }

    // Class Used to define the Review's View Holder
    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        // Attributes in the reusable review component
        TextView restaurantName, date, foodScore, serviceScore, recommended;

        // Constructor
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            date = itemView.findViewById(R.id.date);
            foodScore = itemView.findViewById(R.id.foodScore);
            serviceScore = itemView.findViewById(R.id.serviceScore);
            recommended = itemView.findViewById(R.id.recommended);
        }

        // Set the corresponding data to each reusable review component
        public void setReviewData(Review review) {
            restaurantName.setText(review.getRestaurantName());
            System.out.println(review.getDate());
            date.setText(new SimpleDateFormat("MM-dd-yyyy").format(review.getDate()));
            foodScore.setText("Food Score: " + Integer.toString(review.getFoodScore()));
            serviceScore.setText("Service Score: " + Integer.toString(review.getServiceScore()));
            recommended.setText(review.isRecommended() ? "Recommended" : "Not Recommended");
        }
    }
}
