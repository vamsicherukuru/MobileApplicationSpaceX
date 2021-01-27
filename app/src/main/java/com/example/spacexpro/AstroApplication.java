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

public class AstroApplication extends AppCompatActivity implements View.OnClickListener{


    EditText Regno,Name,Marks,Email,Dob;
    Button Insert,Delete,View,ViewAll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro_application);
        Regno=(EditText)findViewById(R.id.Regno);
        Name=(EditText)findViewById(R.id.name);
        Marks=(EditText)findViewById(R.id.marks);
        Email = (EditText)findViewById(R.id.email);
        Dob= (EditText)findViewById(R.id.dob);
        Insert=(Button)findViewById(R.id.insert);
        Delete=(Button)findViewById(R.id.delete);

        View=(Button)findViewById(R.id.view);
        ViewAll=(Button)findViewById(R.id.viewall);

        Insert.setOnClickListener((android.view.View.OnClickListener) this);
        Delete.setOnClickListener((android.view.View.OnClickListener)this);
        View.setOnClickListener((android.view.View.OnClickListener)this);
        ViewAll.setOnClickListener((android.view.View.OnClickListener)this);

        // Creating database and table
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
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
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('"+Regno.getText()+"','"+Name.getText()+ "', '"+Email.getText()+"','"+Dob.getText()+"','"+Marks.getText()+"');");
            showMessage("Successful", "Application Submitted");
            clearText();
        }
        // Deleting a record from the Student table
        if(view==Delete)
        {
            // Checking for empty roll number
            if(Regno.getText().toString().trim().length()==0)
            {
                showMessage("Invalid", "Mobile Number is mandatory");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+Regno.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM student WHERE rollno='"+Regno.getText()+"'");
                showMessage("Success", "Application Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Mobile Number");
            }
            clearText();
        }
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
                buffer.append("Mobile Number: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Experience: "+c.getString(4)+"\n\n");
                buffer.append("Status: Application submitted for review ");
            }
            showMessage("Application Details", buffer.toString());
//            Intent i =  new Intent(MainActivity.this,MainActivity2.class);
//            i.putExtra("regno",c.getString(0));
//            i.putExtra("name",c.getString(1));
//            i.putExtra("marks",c.getString(4));
//            startActivity(i);
        }
        // Displaying all the records
        if(view==ViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM student", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Regno: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(4)+"\n\n");
            }
            showMessage("Student Details", buffer.toString());
        }
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