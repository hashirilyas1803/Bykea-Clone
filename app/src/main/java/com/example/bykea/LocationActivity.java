package com.example.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Back button → go to HomeActivity
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        });

        // "Find Ride" button → show a confirmation toast (for now)
        Button btnFindRide = findViewById(R.id.btnFindRide);
        btnFindRide.setOnClickListener(v ->
                Toast.makeText(this, "Ride request sent (demo)", Toast.LENGTH_SHORT).show()
        );
    }
}