package com.example.valoranttracking.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.valoranttracking.R;
import com.example.valoranttracking.view.fragments.agentFragment;
import com.example.valoranttracking.view.fragments.mapFragment;
import com.example.valoranttracking.view.fragments.profileFragment;
import com.example.valoranttracking.view.fragments.rankFragment;
import com.example.valoranttracking.view.fragments.weaponFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class mainMenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_profile:
                        selectedFragment = new profileFragment();
                        break;
                    case R.id.nav_agent:
                        selectedFragment = new agentFragment();
                        break;
                    case R.id.nav_maps:
                        selectedFragment = new mapFragment();
                        break;
                    case R.id.nav_weapons:
                        selectedFragment = new weaponFragment();
                        break;
                    case R.id.nav_ranks:
                        selectedFragment = new rankFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();

                return true;
            }
        });
    }
}