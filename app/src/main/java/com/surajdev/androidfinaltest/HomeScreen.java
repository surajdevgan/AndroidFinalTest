package com.surajdev.androidfinaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    String countries[]={"Canada","U.S.A","England"};
    public static ArrayList<Place> allPlaces=new ArrayList<>();
    ArrayList<Place>countryPlaces = new ArrayList<>();
    ArrayList<String>images=new ArrayList<>();

    Spinner sp;
    ListView lv;
    TextView Capital;
  ImageView Flag;
    public static String selectedPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Capital = findViewById(R.id.textView3);
        Flag = findViewById(R.id.flag);
        allPlaces.clear();
        fillData();
        sp=findViewById(R.id.spCountries);
        lv=findViewById(R.id.lvPlaces);

        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countries);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryPlaces.clear();
                fillCountryPlaces(countries[position]);
                lv.setAdapter(new PlaceAdapter(getBaseContext(),countryPlaces));
                if(position==0)
                {

                    Capital.setText("Capital of Canada is Ottawa");
                    Flag.setImageResource(R.drawable.cnd);
                }

                else if(position==1)
                {
                    Capital.setText("Capital of U.S.A is Washington");
                    Flag.setImageResource(R.drawable.us);


                }

                else if(position==2)
                {

                    Capital.setText("Capital of England is London");
                    Flag.setImageResource(R.drawable.en);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                countryPlaces.clear();
                fillCountryPlaces(countries[0]);
                lv.setAdapter(new PlaceAdapter(getBaseContext(),countryPlaces));

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPlace=countryPlaces.get(position).getName();
                Intent intent= new Intent(getBaseContext(), PlaceToVisitActivity.class);
                startActivity(intent);
            }
        });

    }
    public void fillData(){

        countryPlaces.clear();
        fillImages(images,5,"niagara");
        allPlaces.add(new Place("Niagara Falls",countries[0],100, images));

        ArrayList<String>images1=new ArrayList<>();
        fillImages(images1,4,"cntower");
        allPlaces.add(new Place("CN Tower",countries[0],30,images1));

        ArrayList<String>images2=new ArrayList<>();
        fillImages(images2,4,"butchartgarden");
        allPlaces.add(new Place("The Butchart Gardens",countries[0],30,images2));

        ArrayList<String>images3=new ArrayList<>();
        fillImages(images3,4,"notredame");
        allPlaces.add(new Place("Notre-Dame Basilica",countries[0],30,images3));

// ___________________U.S.A__________________________

        ArrayList<String>images4=new ArrayList<>();
        fillImages(images4,4,"liberty");
        allPlaces.add(new Place("The Statue of Liberty",countries[1],90,images4));

        ArrayList<String>images5=new ArrayList<>();
        fillImages(images5,4,"whitehouse");
        allPlaces.add(new Place("The White House",countries[1],60,images5));

        ArrayList<String>images6=new ArrayList<>();
        fillImages(images6,4,"timesquare");
        allPlaces.add(new Place("Times Square",countries[1],75,images6));



        // ____________________England___________________



        ArrayList<String>images7=new ArrayList<>();
        fillImages(images7,4,"bigben");
        allPlaces.add(new Place("Big Ben",countries[2],30,images7));

        ArrayList<String>images8=new ArrayList<>();
        fillImages(images8,4,"westminste");
        allPlaces.add(new Place("Westminster Abbey",countries[2],25,images8));

        ArrayList<String>images9=new ArrayList<>();
        fillImages(images9,4,"hydepark");
        allPlaces.add(new Place("Hyde Park",countries[2],15,images9));



    }
    public void fillImages(ArrayList<String>list,int n,String name){
        list.clear();
        for(int i=0;i<n;i++)
            list.add(name+i);
    }
    public void fillCountryPlaces( String countyName){
        countryPlaces.clear();
        for(Place plc:allPlaces)
            if(plc.getCountryName().equals(countyName))
                countryPlaces.add(plc);

    }
}