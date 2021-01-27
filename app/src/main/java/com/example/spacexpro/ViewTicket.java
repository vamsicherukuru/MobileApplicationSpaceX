package com.example.spacexpro;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;

import android.view.View;

public class ViewTicket extends AppCompatActivity implements View.OnClickListener{


    EditText Regno,Name,Marks,Email,Dob;
    Button Insert,Delete,View,ViewAll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ticket);
        Regno=(EditText)findViewById(R.id.Regno);


        View=(Button)findViewById(R.id.view);



        View.setOnClickListener((android.view.View.OnClickListener)this);

        // Creating database and table
        db=openOrCreateDatabase("LaunchDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,email VARCHAR,dob DATE,marks VARCHAR);");
    }

    public void onClick(View view)
    {
        // Inserting a record to the Student table

        // Deleting a record from the Student table

        // Display a record from the Student table
        if(view==View)
        {
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+Regno.getText()+"'", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "Application Not Found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Mobile Number: "+c.getString(0)+"\n\n");
                buffer.append("Name: "+c.getString(1)+"\n\n");
                buffer.append("Number of persons: "+c.getString(4)+"\n\n");
                buffer.append("Experience: "+c.getString(4)+"\n\nPayment on Location : 1.7$\n\nLaunch Name : Crew-1\n\nScheduled on: 15 November 2020\n\nTime : 00:49 UTC \n\nTime of Reporting : 00:15 UTC\n");
                buffer.append("\nTicket ID: 025788896554 \n\n\n ");
            }
            showMessage("Entry pass", buffer.toString());
//            Intent i =  new Intent(MainActivity.this,MainActivity2.class);
//            i.putExtra("regno",c.getString(0));
//            i.putExtra("name",c.getString(1));
//            i.putExtra("marks",c.getString(4));
//            startActivity(i);
        }
        // Displaying all the records

    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        Regno.setText("");
        Name.setText("");
        Email.setText("");
        Dob.setText("");
        Marks.setText("");
        Regno.requestFocus();
    }
}