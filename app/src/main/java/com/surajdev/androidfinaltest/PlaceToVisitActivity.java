package com.surajdev.androidfinaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceToVisitActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView Visitors, TotalAmount;
    int totalvisitors = 1;
    int totalprice = 0;
    int discountvalue = 0;
    TextView PriceToVisitPlace;
    Place place= getObject(HomeScreen.allPlaces,HomeScreen.selectedPlace);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_to_visit);
        seekBar = findViewById(R.id.visitors);
        Visitors = findViewById(R.id.visit);
        TotalAmount = findViewById(R.id.totalprice);
        PriceToVisitPlace = findViewById(R.id.pricetovisitplace);

        PriceToVisitPlace.setText("Price To Visit this Place is: "+String.valueOf(place.getPrice()));
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
        totalprice = totalvisitors * place.getPrice();



        if(totalvisitors>15)
        {

            discountvalue = totalprice * 5/100;
            totalprice -= discountvalue;

            TotalAmount.setText(String.valueOf(totalprice));
        }

        else {

            TotalAmount.setText(String.valueOf(totalprice));
        }



    }

    //a method that gets the place name and returns it's object
    public Place getObject(ArrayList<Place> places, String name)
    {
        for(Place plc:places)
            if(name.equals(plc.getName()))
                return plc;
        return null;
    }
}