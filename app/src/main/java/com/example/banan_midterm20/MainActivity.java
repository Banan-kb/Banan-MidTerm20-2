package com.example.banan_midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button act2Button= (Button) findViewById(R.id.button1_2);
        Button act3Button= (Button) findViewById(R.id.button1_3);


        Button dateButton= (Button) findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
         new DatePickerDialog(MainActivity.this, d,
           c.get(Calendar.YEAR),
           c.get(Calendar.MONTH),
           c.get(Calendar.DAY_OF_MONTH)).show();
        }
         });

        act2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });


        act3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity3.class));
            }
        });


    }



    Calendar c= Calendar.getInstance();
    DateFormat dtform= DateFormat.getDateInstance();
     DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
             c.set(Calendar.YEAR, year);
             c.set(Calendar.MONTH, month);
             c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
             //res.setText("Your res is "+dtform.format(c.getTime()));
             Toast.makeText(MainActivity.this, "You picked "+dtform.format(c.getTime()),Toast.LENGTH_SHORT ).show();

         }

};

}