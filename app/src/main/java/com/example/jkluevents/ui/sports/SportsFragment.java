package com.example.jkluevents.ui.sports;

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
import com.example.jkluevents.databinding.FragmentSportsBinding;

public class SportsFragment extends Fragment {

    private SportsViewModel sportsViewModel;
    private FragmentSportsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sportsViewModel =
                new ViewModelProvider(this).get(SportsViewModel.class);

        binding = FragmentSportsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSports;
        sportsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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