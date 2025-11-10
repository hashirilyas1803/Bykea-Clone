package com.example.bykea;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class AccessibilityActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessibility);

        prefs = getSharedPreferences("bykea_prefs", MODE_PRIVATE);

        SwitchCompat swScreenReader = findViewById(R.id.swScreenReader);
        SwitchCompat swColorblind   = findViewById(R.id.swColorblind);
        SwitchCompat swUrdu         = findViewById(R.id.swUrdu);
        SwitchCompat swLargerText   = findViewById(R.id.swLargerText);

        // restore saved
        swScreenReader.setChecked(prefs.getBoolean("screen_reader", false));
        swColorblind.setChecked(prefs.getBoolean("colorblind", false));
        swUrdu.setChecked(prefs.getBoolean("urdu", false));
        swLargerText.setChecked(prefs.getBoolean("larger_text", false));

        CompoundButton.OnCheckedChangeListener saver = (buttonView, isChecked) -> {
            String key = (String) buttonView.getTag();
            prefs.edit().putBoolean(key, isChecked).apply();
            Toast.makeText(this, getString(R.string.demo_saved), Toast.LENGTH_SHORT).show();
        };

        swScreenReader.setTag("screen_reader");
        swColorblind.setTag("colorblind");
        swUrdu.setTag("urdu");
        swLargerText.setTag("larger_text");

        swScreenReader.setOnCheckedChangeListener(saver);
        swColorblind.setOnCheckedChangeListener(saver);
        swUrdu.setOnCheckedChangeListener(saver);
        swLargerText.setOnCheckedChangeListener(saver);
    }
}