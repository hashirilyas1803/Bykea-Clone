package com.example.bykea;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    private LinearLayout locationInputLayout, driverOfferLayout, customFareLayout;
    private RadioGroup rideOptionsGroup;
    private Button btnFindRide, btnCancelRide, btnReject, btnAccept, btnIncreaseFare, btnDecreaseFare;
    private EditText etCustomFare;
    private TextView tvOfferedFare;

    private int currentFare = 0;
    private boolean hasActiveOffer = false;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Initialize views
        locationInputLayout = findViewById(R.id.locationInputLayout);
        driverOfferLayout = findViewById(R.id.driverOfferLayout);
        customFareLayout = findViewById(R.id.customFareLayout);
        rideOptionsGroup = findViewById(R.id.rideOptionsGroup);
        btnFindRide = findViewById(R.id.btnFindRide);
        btnCancelRide = findViewById(R.id.btnCancelRide);
        btnReject = findViewById(R.id.btnReject);
        btnAccept = findViewById(R.id.btnAccept);
        etCustomFare = findViewById(R.id.etCustomFare);
        tvOfferedFare = findViewById(R.id.tvOfferedFare);
        btnIncreaseFare = findViewById(R.id.btnIncreaseFare);
        btnDecreaseFare = findViewById(R.id.btnDecreaseFare);

        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        // Show custom fare section after selecting a ride
        rideOptionsGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) {
                customFareLayout.setVisibility(View.VISIBLE);
            }
        });

        // When Find Ride is clicked
        btnFindRide.setOnClickListener(v -> {
            String fareText = etCustomFare.getText().toString().trim();
            if (fareText.isEmpty()) {
                Toast.makeText(this, "Please enter a fare amount", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                currentFare = Integer.parseInt(fareText);
            } catch (NumberFormatException e) {
                currentFare = 0;
            }

            tvOfferedFare.setText(String.valueOf(currentFare));
            locationInputLayout.setVisibility(View.GONE);
            driverOfferLayout.setVisibility(View.VISIBLE);
            hasActiveOffer = true;
        });

        // Increase/decrease fare buttons
        btnIncreaseFare.setOnClickListener(v -> {
            currentFare += 10;
            tvOfferedFare.setText(String.valueOf(currentFare));
        });

        btnDecreaseFare.setOnClickListener(v -> {
            if (currentFare > 0) {
                currentFare -= 10;
                tvOfferedFare.setText(String.valueOf(currentFare));
            }
        });

        // Accept driver
        btnAccept.setOnClickListener(v ->
                Toast.makeText(this, "Ride accepted (demo)", Toast.LENGTH_SHORT).show()
        );

        // Reject driver
        btnReject.setOnClickListener(v -> {
            View driverCard = (View) v.getParent();
            driverCard.setVisibility(View.GONE);
            hasActiveOffer = false;
            Toast.makeText(this, "Driver offer removed", Toast.LENGTH_SHORT).show();

            // Regenerate driver offer every 5 seconds if not cancelled
            handler.postDelayed(() -> {
                if (!hasActiveOffer && driverOfferLayout.getVisibility() == View.VISIBLE) {
                    driverCard.setVisibility(View.VISIBLE);
                    hasActiveOffer = true;
                    Toast.makeText(this, "New driver offer arrived", Toast.LENGTH_SHORT).show();
                }
            }, 5000);
        });

        // Cancel ride
        btnCancelRide.setOnClickListener(v -> {
            driverOfferLayout.setVisibility(View.GONE);
            locationInputLayout.setVisibility(View.VISIBLE);
            rideOptionsGroup.clearCheck();
            customFareLayout.setVisibility(View.GONE);
            etCustomFare.setText("");
            hasActiveOffer = false;
            Toast.makeText(this, "Ride cancelled", Toast.LENGTH_SHORT).show();
        });
    }
}