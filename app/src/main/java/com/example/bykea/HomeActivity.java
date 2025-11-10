package com.example.bykea;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btnMenu).setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            Toast.makeText(this, getString(R.string.demo_open_accessibility), Toast.LENGTH_SHORT).show();
        });

        LinearLayout cardRide = findViewById(R.id.cardRide);
        LinearLayout cardHelpline = findViewById(R.id.cardHelpline);
        LinearLayout cardDelivery = findViewById(R.id.cardDelivery);

        cardRide.setOnClickListener(v -> {
            startActivity(new Intent(this, LocationActivity.class));
            Toast.makeText(this, getString(R.string.demo_ride), Toast.LENGTH_SHORT).show();
        });

        cardHelpline.setOnClickListener(v -> {
            // Open Helpline screen
            Intent intent = new Intent(HomeActivity.this, HelplineActivity.class);
            startActivity(intent);
        });

        cardDelivery.setOnClickListener(v ->
                Toast.makeText(this, getString(R.string.demo_delivery), Toast.LENGTH_SHORT).show());
    }
}