package com.example.banan_midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        myDB= new DatabaseHelper(this);

        //myDB.addData("Banan","AlBatati","+96612345678","1234567890"); for populating database

        final TextView nameView= (TextView) findViewById(R.id.nameView);
        final TextView lnameView= (TextView) findViewById(R.id.lnameView);
        final TextView phoneView= (TextView) findViewById(R.id.phoneView);
        final TextView nIDView= (TextView) findViewById(R.id.nIDView);


        Button readButton= (Button) findViewById(R.id.readButton);
        Button delButton= (Button) findViewById(R.id.delButton);

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= myDB.structuredQuery();

                String dbnID = cursor.getString(4);
                String dbFName = cursor.getString(1);
                String dbLName = cursor.getString(2);
                String dbPhone = cursor.getString(3);

                nameView.setText("Name: "+dbFName);
                lnameView.setText("Last Name: "+dbLName);
                phoneView.setText("Phone: "+dbPhone);
                nIDView.setText("Name: "+dbnID);

                //Toast.makeText(Activity2.this, "dropped",Toast.LENGTH_SHORT ).show();

            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nIDVal= nIDView.getText().toString();

                myDB.deleteData(nIDVal);

                Toast.makeText(Activity2.this, "Successful DELETE",Toast.LENGTH_SHORT ).show();

            }
        });

        Button act21Button= (Button) findViewById(R.id.button2_1);
        Button act23Button= (Button) findViewById(R.id.button2_3);

        act21Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, MainActivity.class));
            }
        });


        act23Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Activity3.class));
            }
        });




    }
}