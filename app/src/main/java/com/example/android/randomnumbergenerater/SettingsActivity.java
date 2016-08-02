package com.example.android.randomnumbergenerater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView backgroundSettings = (TextView) findViewById(R.id.background_settings_view);
        backgroundSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backgroundSettingsIntent = new Intent(SettingsActivity.this, backgroundSettingsActivity.class);
                startActivity(backgroundSettingsIntent);
            }
        });
    }

    public void openResetSettingsActivity(View view){
        Intent resetSettingsIntent = new Intent(this, ResetSettingsActivity.class);
        startActivity(resetSettingsIntent);
    }

}
