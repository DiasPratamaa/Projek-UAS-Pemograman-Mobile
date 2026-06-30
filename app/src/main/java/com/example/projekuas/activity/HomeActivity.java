package com.example.projekuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.projekuas.util.ThemeHelper;
import com.example.projekuas.fragment.ProfileFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.projekuas.R;
import com.example.projekuas.fragment.HewanFragment;
import com.example.projekuas.fragment.TumbuhanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    private ImageButton btnFavorite;

    private ImageButton btnSearch;
    private ImageButton btnDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnDarkMode = findViewById(R.id.btnDarkMode);
        btnSearch = findViewById(R.id.btnSearch);

        // Fragment pertama
        loadFragment(new HewanFragment());

        bottomNavigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.menu_hewan) {

                loadFragment(new HewanFragment());

            } else if (item.getItemId() == R.id.menu_tumbuhan) {

                loadFragment(new TumbuhanFragment());

            } else if (item.getItemId() == R.id.menu_profile) {

                loadFragment(new ProfileFragment());

            }

            return true;

        });

        btnFavorite.setOnClickListener(v -> {

            startActivity(new Intent(
                    HomeActivity.this,
                    FavoriteActivity.class));

        });

        btnSearch.setOnClickListener(v -> {

            // Nanti kita buat Search

        });

        btnDarkMode.setOnClickListener(v -> {

            ThemeHelper.toggleTheme(this);

            recreate();

        });

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .commit();

    }



}