package com.example.ameassistant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Attempts to launch activity within our own app
        Button goCalendarBtn = (Button) findViewById(R.id.goCalendarBtn);
        goCalendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), ShowCalendar.class);
                // Show how to pass information to another activity
                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
                startActivity(Intent1);
            }
        });

        Button goListBtn = (Button) findViewById(R.id.goListBtn);
        goListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), list.class);
                // Show how to pass information to another activity
//                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
                startActivity(Intent1);
            }
        });

        Button goItinerariesBtn = (Button) findViewById(R.id.goItinerariesButton);
        goItinerariesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), ItineraryOptions.class);
                // Show how to pass information to another activity
//                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
                startActivity(Intent1);
            }
        });

        //Attempt to launch an activity outside our app
        Button googleBtn = (Button) findViewById(R.id.mapsBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                String google = "http://www.yahoo.com";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
//                if (gotoGoogle.resolveActivity(getPackageManager()) != null){
//
//                }
                startActivity(gotoGoogle);
            }
        });



        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                TextView resulttextView = (TextView) findViewById(R.id.resulttextView);

                int num1 = Integer.parseInt(editTextTextPersonName.getText().toString());
                int num2 = Integer.parseInt(editTextTextPersonName2.getText().toString());
                int result = num1 + num2;
                resulttextView.setText(result + "");
            }
        });

//        Button emergencyBtn = (Button) findViewById(R.id.emergencyBtn);
//        emergencyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Intent1 = new Intent(getApplicationContext(), ShowCalendar.class);
//                // Show how to pass information to another activity
//                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
//                startActivity(Intent1);
//            }
//        });

    }
}