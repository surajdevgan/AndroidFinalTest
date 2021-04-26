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





    /*


        ArrayList<String>images3=new ArrayList<>();
        fillImages(images3,3,"taj");
        allPlaces.add(new Place("Taj Mahal",countries[1],"An immense mausoleum of white marble, built in Agra between 1631 and 1648 by order of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal is the jewel of Muslim art in India and one of the universally admired masterpieces of the world's heritage",images3));
        ArrayList<String>images4=new ArrayList<>();
        fillImages(images4,5,"fort");
        allPlaces.add(new Place("Mehrangarh Fort",countries[1],"Mehrangarh, located in Jodhpur, Rajasthan, is one of the largest forts in India. Built around 1459 by Rao Jodha, the fort is situated 410 feet above the city and is enclosed by imposing thick walls. Inside its boundaries there are several palaces known for their intricate carvings and expansive courtyards",images4));
        ArrayList<String>images5=new ArrayList<>();
        fillImages(images5,4,"golden");
        allPlaces.add(new Place("Golden Temple",countries[1],"Harmandir Sahib, Harmandir also spelled Harimandir, also called Darbar Sahib (Punjabi: “Sacred Audience”) or Golden Temple, the chief gurdwara, or house of worship, of Sikhism and the Sikhs' most important pilgrimage site. It is located in the city of Amritsar, Punjab state, northwestern India.",images5));
        ArrayList<String>images6=new ArrayList<>();
        fillImages(images6,5,"guatape");
        allPlaces.add(new Place("Guatape",countries[2],"Guatapé is an Andean resort town in northwest Colombia, east of Medellín. It’s known for its houses decorated with colorful bas-reliefs. It sits by the vast, man-made Peñol-Guatapé Reservoir, a busy water-sports center. Piedra del Peñol, a giant granite rock southwest of town, has hundreds of steps to the top",images6 ));
        ArrayList<String>images7=new ArrayList<>();
        fillImages(images7,8,"river");
        allPlaces.add(new Place("Seven Colors River",countries[2],"Caño Cristales is a Colombian river located in the Serrania de la Macarena province of Meta, and is a tributary of the Guayabero River. The river is commonly called the \"River of Five Colors\" or the \"Liquid Rainbow,\" and is noted for its striking colors.",images7));
        ArrayList<String>images8=new ArrayList<>();
        fillImages(images8,4,"dunas");
        allPlaces.add(new Place("Las Dunas De Bani",countries[3],"Dunas de Bani is a small island with 15 kilometers of just pure sand stretching from the town of Matanzas to Las Salinas at Puerto Hermoso, Santo Domingo.\n" +
                "\n" +
                "Amid the brown sand dunes, you will find native flora like cacti, olive trees, and other plants. To inquire about filming at this location, visit LocationsHub.com.",images8));
        ArrayList<String>images9=new ArrayList<>();
        fillImages(images9,6,"los");
        allPlaces.add(new Place("Los Haitises",countries[3],"Los Haitises National Park is a national park located on the remote northeast coast of the Dominican Republic that was established in 1976. It consists of a limestone karst plateau with conical hills, sinkholes and caverns, and there is a large area of mangrove forest on the coast. Wikipedia",images9));
        ArrayList<String>images10=new ArrayList<>();
        fillImages(images10,3,"petra");
        allPlaces.add(new Place("Petra",countries[4],"Petra is a famous archaeological site in Jordan's southwestern desert. Dating to around 300 B.C., it was the capital of the Nabatean Kingdom. Accessed via a narrow canyon called Al Siq, it contains tombs and temples carved into pink sandstone cliffs, earning its nickname, the \"Rose City",images10));
        ArrayList<String>images11=new ArrayList<>();
        fillImages(images11,3,"rum");
        allPlaces.add(new Place("Wadi Rum",countries[4],"Wadi Rum is a protected desert wilderness in southern Jordan. It features dramatic sandstone mountains like the many-domed Jebel Um Ishrin, and natural arches such as Burdah Rock Bridge. Many prehistoric inscriptions and carvings line rocky caverns and steep chasms",images11));
        ArrayList<String>images12=new ArrayList<>();
        fillImages(images12,5,"main");
        allPlaces.add(new Place("Ma'in Hot Springs",countries[4],"The Ma'in Hot Springs also known as Hammamat Ma'in are a series of hot mineral springs and waterfalls located between Madaba and the Dead Sea in Madaba Governorate, Jordan.",images12));
        ArrayList<String>images13=new ArrayList<>();
        fillImages(images13,4,"sea");
        allPlaces.add(new Place("Dead Sea",countries[4],"The Dead Sea is a salt lake bordered by Jordan to the east and Israel and the West Bank to the west. It lies in the Jordan Rift Valley, and its main tributary is the Jordan River. The lake's surface is 430.5 metres below sea level, making its shores the lowest land-based elevation on Earth",images13));

        */

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