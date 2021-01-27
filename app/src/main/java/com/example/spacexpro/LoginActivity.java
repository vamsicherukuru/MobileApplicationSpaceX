package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }




    public void logged(View v){
        final EditText et = (EditText) findViewById(R.id.username);
        final EditText pw = (EditText) findViewById(R.id.password);
        String un = et.getText().toString();
        String pasw = pw.getText().toString();

        if(un.equals("vamsi") && pasw.equals("1234")){

            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_LONG).show();
        }



    }
}
