package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.annotation.TargetApi;

public class HomeActivity extends AppCompatActivity {
//
    public int counter = 60;
    public int mincounter = 60;
    public int hrcounter = -72;
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TextView counttime=findViewById(R.id.counttime);
        final TextView minutes=findViewById(R.id.minutes);
        final TextView hours=findViewById(R.id.hours);
        new CountDownTimer(5000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (counter == 0){
                    counter = 60;
                }
                counttime.setText(String.valueOf(counter));

                counter--;
            }
            @Override
            public void onFinish() {
                counttime.setText("Finished");
            }
        }.start();



        new CountDownTimer(5000000,1000*30*2) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (mincounter == 0){
                    mincounter = 60;
                    minutes.setText(String.valueOf(mincounter));
                }
                else{
                minutes.setText(String.valueOf(mincounter));

                mincounter--;
            }}
            @Override
            public void onFinish() {
                minutes.setText("Finished");
            }
        }.start();


        new CountDownTimer(5000000,1000*30*2*60) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (hrcounter == 0){
                    hrcounter = 60;
                    hours.setText(String.valueOf(hrcounter));
                }
                else{
                    hours.setText(String.valueOf(hrcounter));

                    hrcounter++;
                }}
            @Override
            public void onFinish() {
                minutes.setText("Finished");
            }
        }.start();
















    }

    public void vehicle(View v){


        Intent i = new Intent(this, VehicleActivity.class);

        startActivity(i);


    }
    public void latest(View v){


        Intent i = new Intent(this, LatestActivity.class);

        startActivity(i);


    }
    public void upcoming(View v){


        Intent i = new Intent(this, UpcomingActivity.class);

        startActivity(i);


    }
    public void astrohome(View v){


        Intent i = new Intent(this, AstronautMain.class);

        startActivity(i);


    }
    public void shop(View v){


        Intent i = new Intent(this, ShopHome.class);

        startActivity(i);


    }
           public void launch(View v){


            Intent i = new Intent(this, BookHome.class);

            startActivity(i);


        }

}
