package com.example.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btnRideHistory = findViewById(R.id.btnRideHistory);
        btnRideHistory.setOnClickListener(v ->
                startActivity(new Intent(this, RideHistoryActivity.class))
        );
        Button btnSavedPlaces = findViewById(R.id.btnSavedPlaces);
        btnSavedPlaces.setOnClickListener(v ->
                startActivity(new Intent(this, SavedLocationsActivity.class)));
        Button btnAccessibility = findViewById(R.id.btnAccessibility);
        btnAccessibility.setOnClickListener(v ->
                startActivity(new Intent(this, AccessibilityActivity.class)));

    }
}