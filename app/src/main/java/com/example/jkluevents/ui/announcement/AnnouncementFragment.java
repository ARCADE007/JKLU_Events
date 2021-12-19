package com.example.jkluevents.ui.announcement;

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

import com.example.jkluevents.databinding.FragmentAnnouncementBinding;

public class AnnouncementFragment extends Fragment {

    private AnnouncementViewModel announcementViewModel;
    private FragmentAnnouncementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        announcementViewModel =
                new ViewModelProvider(this).get(AnnouncementViewModel.class);

        binding = FragmentAnnouncementBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAnnouncement;
        announcementViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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