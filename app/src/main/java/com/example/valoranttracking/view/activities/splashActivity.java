package com.example.valoranttracking.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.valoranttracking.R;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            //habis splash screen lalu pindah ke login
            Intent agent = new Intent(this, loginActivity.class);
            startActivity(agent);
            finish();
        },2000);


    }

}