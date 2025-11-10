package com.example.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OtpActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);

        EditText[] otpFields = {otp1, otp2, otp3, otp4};

        for (int i = 0; i < otpFields.length; i++) {
            final int index = i;

            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1 && index < otpFields.length - 1) {
                        otpFields[index + 1].requestFocus(); // Move to next field
                    } else if (s.length() == 0 && index > 0) {
                        otpFields[index - 1].requestFocus(); // Go back
                    }

                    // Check if all fields are filled
                    if (areAllOtpFieldsFilled(otpFields)) {
                        navigateToHome();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }

    private boolean areAllOtpFieldsFilled(EditText[] fields) {
        for (EditText field : fields) {
            if (field.getText().toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void navigateToHome() {
        // Optional: prevent multiple triggers if user edits fields again
        otp4.clearFocus();

        Intent intent = new Intent(OtpActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}