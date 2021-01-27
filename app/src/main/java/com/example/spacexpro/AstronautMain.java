package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AstronautMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronaut_main);
    }

    public void astroapplication(View v){


        Intent i = new Intent(this, AstroApplication.class);

        startActivity(i);


    }
}
