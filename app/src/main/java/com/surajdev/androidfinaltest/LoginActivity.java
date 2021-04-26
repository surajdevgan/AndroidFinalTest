package com.surajdev.androidfinaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText  UserName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
     //   startActivity(new Intent(this, HomeScreen.class));
    }

    public void Login(View view) {


        if(UserName.getText().toString().equals("user1") && Password.getText().toString().equals("password1"))
        {


            startActivity(new Intent(this, HomeScreen.class));
            Toast.makeText(this, "User Successfully  login", Toast.LENGTH_LONG).show();
            finish();
        }

        else
        {

            Toast.makeText(this, "Invalid UserName OR Password", Toast.LENGTH_SHORT).show();

        }

    }
}