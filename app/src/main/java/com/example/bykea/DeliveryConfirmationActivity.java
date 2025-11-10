package com.example.bykea;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class DeliveryConfirmationActivity extends AppCompatActivity {

    private EditText etPickupAddress, etPickupName, etPickupMobile;
    private EditText etDropoffAddress, etDropoffName, etDropoffMobile;
    private Button btnConfirmParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_confirmation);

        etPickupAddress = findViewById(R.id.etPickupAddress);
        etPickupName = findViewById(R.id.etPickupName);
        etPickupMobile = findViewById(R.id.etPickupMobile);
        etDropoffAddress = findViewById(R.id.etDropoffAddress);
        etDropoffName = findViewById(R.id.etDropoffName);
        etDropoffMobile = findViewById(R.id.etDropoffMobile);
        btnConfirmParcel = findViewById(R.id.btnConfirmParcel);

        btnConfirmParcel.setOnClickListener(v -> {
            // For now, just go back to home (you can change this later)
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.btnBackConfirm).setOnClickListener(v -> onBackPressed());
    }
}