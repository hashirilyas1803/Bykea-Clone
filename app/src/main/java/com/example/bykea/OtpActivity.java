package com.example.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Auto-switch logic between OTP boxes
        EditText otp1 = findViewById(R.id.otp1);
        EditText otp2 = findViewById(R.id.otp2);
        EditText otp3 = findViewById(R.id.otp3);
        EditText otp4 = findViewById(R.id.otp4);

        EditText[] otpFields = {otp1, otp2, otp3, otp4};

        for (int i = 0; i < otpFields.length; i++) {
            final int index = i;
            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1 && index < otpFields.length - 1) {
                        otpFields[index + 1].requestFocus(); // move forward
                    } else if (s.length() == 0 && index > 0) {
                        otpFields[index - 1].requestFocus(); // move back
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }

        // Show toast + navigate when last box loses focus ===
        otp4.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Toast.makeText(this, "Login successful (demo)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
        });
    }
}