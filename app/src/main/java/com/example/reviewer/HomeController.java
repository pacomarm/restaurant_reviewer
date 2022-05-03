package com.example.reviewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.reviewer.databinding.HomeFragmentBinding;

public class HomeController extends Fragment {

    // Controller class for the Home View

    private HomeFragmentBinding binding; // Binding attribute to the HomeFragment

    // Overriding this method to create and bind the corresponding HomeView with this controller
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    // Method called right after onCreateView
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting an on click listener to the buttonReviews button, to move to the Reviews View
        binding.buttonReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.button_reviews ){
                    Intent intent = new Intent(getActivity(), ReviewsController.class);
                    startActivity(intent);
                }
            }
        });

        // Setting an on click listener to the buttonRestaurants button, to move to the Restaurants View
        binding.buttonRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button_restaurants ){
                    Intent intent = new Intent(getActivity(), RestaurantsController.class);
                    startActivity(intent);
                }
            }
        });

    }

    // Method ran when the view is destroyed, removing the binding.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}