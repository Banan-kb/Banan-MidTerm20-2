package com.example.banan_midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        myDB= new DatabaseHelper(this);

        Button dButton= (Button) findViewById(R.id.dButton);
        Button sButton= (Button) findViewById(R.id.sButton);

        final EditText nIDEdit= (EditText) findViewById(R.id.nIDEdit);
        final TextView infoView= (TextView) findViewById(R.id.infoView);

        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nIDVal= nIDEdit.getText().toString();

                myDB.deleteData(nIDVal);

                Toast.makeText(Activity3.this, "Successful DELETE",Toast.LENGTH_SHORT ).show();



            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nIDVal= nIDEdit.getText().toString();
               Cursor cursor= myDB.getSpecificResult(nIDVal);
                String dbnID = cursor.getString(4);
                String dbFName = cursor.getString(1);
                String dbLName = cursor.getString(2);
                String dbPhone = cursor.getString(3);

                infoView.setText("national ID: " + dbnID + "\nFirst Name: " + dbFName + "\nLast Name: " + dbLName + "\nPhone: " + dbPhone);
            }
        });

        Button act31Button= (Button) findViewById(R.id.button3_1);
        Button act32Button= (Button) findViewById(R.id.button3_2);

        act31Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this, MainActivity.class));
            }
        });


        act32Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this, Activity2.class));
            }
        });
    }
}