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

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Review> listReviews;

    public AdapterDatos(ArrayList<Review> listReviews) {
        this.listReviews = listReviews;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return listReviews.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView restaurantName, date, foodScore, serviceScore, recommended;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            date = itemView.findViewById(R.id.date);
            foodScore = itemView.findViewById(R.id.foodScore);
            serviceScore = itemView.findViewById(R.id.serviceScore);
            recommended = itemView.findViewById(R.id.recommended);
        }

        public void asignarDatos(Review review) {
            restaurantName.setText(review.getRestaurantName());
            System.out.println(review.getDate());
            date.setText(new SimpleDateFormat("MM-dd-yyyy").format(review.getDate()));
            foodScore.setText(Integer.toString(review.getFoodScore()));
            serviceScore.setText(Integer.toString(review.getServiceScore()));
            recommended.setText(review.isRecommended() ? "Recommended" : "Not Recommended");
        }
    }
}
