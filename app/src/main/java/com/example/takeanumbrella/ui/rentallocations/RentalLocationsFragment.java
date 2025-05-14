package com.example.takeanumbrella.ui.rentallocations;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.databinding.FragmentRentalLocationsBinding;

import java.util.ArrayList;

public class RentalLocationsFragment extends Fragment {

    private FragmentRentalLocationsBinding binding;
    private ArrayList<RentalLocation> rentalLocations;

    private SearchView searchView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRentalLocationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView rentalLocationList = binding.rentalLocationList;
        searchView = binding.searchView;
        searchView.clearFocus();
        loadRentalLocations(""); // for demonstration
        rentalLocations = new ArrayList<>();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadRentalLocations(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


        RentalLocationsAdapter adapter = new RentalLocationsAdapter(getContext(), R.layout.fragment_rental_locations_item, rentalLocations);
        rentalLocationList.setAdapter(adapter);

        return root;
    }

    private void loadRentalLocations(String query) {
        RentalLocationsViewModel rentalLocationsViewModel =
                new ViewModelProvider(this).get(RentalLocationsViewModel.class);

        rentalLocationsViewModel.getRentalLocations(query).observe(getViewLifecycleOwner(), locations -> {
            Log.i("Umbrellas OnCreateFragment", "searchQuery " + query);
            rentalLocations.clear();
            if (locations != null)
                rentalLocations.addAll(locations);
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}