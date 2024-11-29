package com.example.takeanumbrella.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.takeanumbrella.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private FragmentProfileBinding binding;

    private TextView userName;
    private TextView textProfile;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        userName = binding.clientName;
        profileViewModel.getText().observe(getViewLifecycleOwner(), userName::setText);

        textProfile = binding.profileInfo;
        profileViewModel.getText().observe(getViewLifecycleOwner(), textProfile::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onRefresh() {
        Log.i("SwipeRefresh", "Got Swipe");
    }
}