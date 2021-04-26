package com.surajdev.androidfinaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

            handler.postDelayed(new Runnable() {@Override
            public void run() {


                startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                finish();

            }
            }, 3000);

        }


    }
