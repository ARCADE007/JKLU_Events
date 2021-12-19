package com.example.jkluevents;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ScrollView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jkluevents.databinding.ActivitySidebarBinding;
import com.google.firebase.firestore.FirebaseFirestore;

public class sidebar extends AppCompatActivity {
    private ScrollView scrollView;
    private FirebaseFirestore db;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySidebarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scrollView = findViewById(R.id.scrollView);

        db = FirebaseFirestore.getInstance();
        binding = ActivitySidebarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarSidebar.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_announcement, R.id.nav_coding, R.id.nav_music, R.id.nav_sports, R.id.nav_dance, R.id.nav_drama)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}