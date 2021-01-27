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

public class BookForm extends AppCompatActivity implements View.OnClickListener{


    EditText Regno,Name,Marks,Email,Dob;
    Button Insert,Delete,View,ViewAll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);
        Regno=(EditText)findViewById(R.id.Regno);
        Name=(EditText)findViewById(R.id.name);
        Marks=(EditText)findViewById(R.id.marks);
        Email = (EditText)findViewById(R.id.email);
        Dob= (EditText)findViewById(R.id.dob);
        Insert=(Button)findViewById(R.id.insert);
        ;

        Insert.setOnClickListener((android.view.View.OnClickListener) this);


        // Creating database and table
        db=openOrCreateDatabase("LaunchDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,email VARCHAR,dob DATE,marks VARCHAR);");
    }

    public void onClick(View view)
    {
        // Inserting a record to the Student table
        if(view==Insert)
        {
            // Checking for empty fields
            if(Regno.getText().toString().trim().length()==0||
                    Name.getText().toString().trim().length()==0||
                    Email.getText().toString().trim().length()==0 ||
                    Dob.getText().toString().trim().length()==0 ||
                    Marks.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Fill in All the details");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('"+Regno.getText()+"','"+Name.getText()+ "', '"+Email.getText()+"','"+Dob.getText()+"','"+Marks.getText()+"');");
            showMessage("", "Tickets Confirmed");
            clearText();
        }
        // Deleting a record from the Student table

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