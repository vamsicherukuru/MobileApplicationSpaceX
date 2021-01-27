package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_home);
    }
    public void bookform(View v){


        Intent i = new Intent(this, BookForm.class);

        startActivity(i);


    }
    public void viewtick(View v){


        Intent i = new Intent(this, ViewTicket.class);

        startActivity(i);


    }
}
