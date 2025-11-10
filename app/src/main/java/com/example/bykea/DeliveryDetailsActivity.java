package com.example.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class DeliveryDetailsActivity extends AppCompatActivity {

    private EditText etParcelValue;
    private Switch switchCOD;
    private RadioGroup radioGroupPayer;
    private Button btnFindCourier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        etParcelValue = findViewById(R.id.etParcelValue);
        switchCOD = findViewById(R.id.switchCOD);
        radioGroupPayer = findViewById(R.id.radioGroupPayer);
        btnFindCourier = findViewById(R.id.btnFindCourier);

        btnFindCourier.setOnClickListener(v -> {
            Intent intent = new Intent(this, DeliveryConfirmationActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> onBackPressed());
    }
}