package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class shirtCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_checkout);
    }
    public void payed(View v){


        Intent i = new Intent(this, HomeActivity.class);
        Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_LONG).show();

        startActivity(i);


    }
}
