package com.example.projekuas.activity;
import com.example.projekuas.util.ThemeHelper;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;

public class SplashActivity extends AppCompatActivity {

    Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnLanjut = findViewById(R.id.btnLanjut);

        btnLanjut.setOnClickListener(v -> {

            Intent intent =
                    new Intent(SplashActivity.this,
                            DownloadActivity.class);

            startActivity(intent);
            finish();

        });

    }

}