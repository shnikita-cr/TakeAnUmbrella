package com.example.takeanumbrella.ui.Umbrella_in_palce;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.takeanumbrella.data.Umbrella.Umbrella;
import com.example.takeanumbrella.databinding.FragmentUmbrellasInPlaceBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.takeanumbrella.R;

import java.util.ArrayList;

public class Umbrellas_in_placeFragment extends Fragment {

    private UmbrellasInPlaceViewModel mViewModel;
    private RecyclerView umbrellas;
    private FragmentUmbrellasInPlaceBinding binding;
    public static Umbrellas_in_placeFragment newInstance() {
        return new Umbrellas_in_placeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        UmbrellasInPlaceViewModel umbrellasInPlaceViewModel = new ViewModelProvider(this).get(UmbrellasInPlaceViewModel.class);
        binding = FragmentUmbrellasInPlaceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SharedPreferences preferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        long placeId = preferences.getLong("placeId", -1); // -1 nếu không tìm thấy
        umbrellas = binding.umbrellas;
        ArrayList<Umbrella> umbrellas_in_place = new ArrayList<>();
        umbrellasInPlaceViewModel.getUmbrellas(placeId).observe(getViewLifecycleOwner(), umbrellas->{
            if(umbrellas != null)
                umbrellas_in_place.addAll(umbrellas);
        });
        UmbrellasInPlaceAdapter adapter = new UmbrellasInPlaceAdapter(getContext(), R.layout.fragment_umbrellas_in_place_item, umbrellas_in_place);
        //umbrellas.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}