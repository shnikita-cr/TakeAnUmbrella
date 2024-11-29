package com.example.takeanumbrella.ui.umbrellas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.RentalLocation.RentalLocation;
import com.example.takeanumbrella.databinding.FragmentUmbrellasBinding;

import java.util.ArrayList;

public class UmbrellasFragment extends Fragment {

    private FragmentUmbrellasBinding binding;
    private ListView rentalLocationList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UmbrellasViewModel umbrellasViewModel =
                new ViewModelProvider(this).get(UmbrellasViewModel.class);

        binding = FragmentUmbrellasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rentalLocationList = binding.rentalLocationList;
        ArrayList<RentalLocation> rentalLocations = new ArrayList<>();
        umbrellasViewModel.getRentalLocations().observe(getViewLifecycleOwner(), locations -> {
            if (locations != null)
                rentalLocations.addAll(locations);
        });

        RentalLocationAdapter adapter = new RentalLocationAdapter(getContext(), R.layout.fragment_umbrellas_places_item, rentalLocations);
        rentalLocationList.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}