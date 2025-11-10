package com.example.bykea;

import android.content.Intent;
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
            // Open Profile page instead of Accessibility
            startActivity(new Intent(this, ProfileActivity.class));
        });

        LinearLayout cardRide = findViewById(R.id.cardRide);
        LinearLayout cardHelpline = findViewById(R.id.cardHelpline);
        LinearLayout cardDelivery = findViewById(R.id.cardDelivery);

        // 🚗 RIDE → Location screen
        cardRide.setOnClickListener(v -> {
            startActivity(new Intent(this, LocationActivity.class));
            Toast.makeText(this, "Ride booking demo", Toast.LENGTH_SHORT).show();
        });

        // ☎️ HELPLINE → Helpline screen
        cardHelpline.setOnClickListener(v -> {
            startActivity(new Intent(this, HelplineActivity.class));
        });

        // 📦 DELIVERY → DeliveryDetailsActivity (then flows to confirmation)
        cardDelivery.setOnClickListener(v -> {
            Intent intent = new Intent(this, DeliveryDetailsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Delivery demo", Toast.LENGTH_SHORT).show();
        });
    }
}