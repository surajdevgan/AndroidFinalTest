package com.surajdev.androidfinaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlaceToVisitActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView Visitors;
    int totalvisitors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_to_visit);
        seekBar = findViewById(R.id.visitors);
        Visitors = findViewById(R.id.visit);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Visitors.setText("Total Visitors are: " + String.valueOf(progress));
                totalvisitors = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void Calculate(View view) {


    }
}