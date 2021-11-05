package com.example.jkluevents.ui.dance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.jkluevents.databinding.FragmentDanceBinding;


public class DanceFragment extends Fragment {

    private DanceViewModel danceViewModel;
    private FragmentDanceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        danceViewModel =
                new ViewModelProvider(this).get(DanceViewModel.class);

        binding = FragmentDanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDance;
        danceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}