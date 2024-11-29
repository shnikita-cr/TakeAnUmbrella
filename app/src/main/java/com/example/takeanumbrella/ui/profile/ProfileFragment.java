package com.example.takeanumbrella.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.Rental.Rental;
import com.example.takeanumbrella.databinding.FragmentProfileBinding;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private TextView clientName;
    private TextView profileInfo;

    private ListView rentalList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        clientName = binding.clientName;
        profileViewModel.getClientName().observe(getViewLifecycleOwner(), clientName::setText);

        profileInfo = binding.profileInfo;
        profileViewModel.getProfileInfo().observe(getViewLifecycleOwner(), profileInfo::setText);


        rentalList = binding.rentalList;
        ArrayList<Rental> rentalHistory = new ArrayList<>();
        profileViewModel.getRentalHistory().observe(getViewLifecycleOwner(), rentals -> {
            if (rentals != null)
                rentalHistory.addAll(rentals);
        });

        RentalHistoryAdapter adapter = new RentalHistoryAdapter(getContext(), R.layout.fragment_profile_history_item, rentalHistory);
        rentalList.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}