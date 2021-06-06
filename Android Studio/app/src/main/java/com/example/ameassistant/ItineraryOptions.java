package com.example.ameassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ItineraryOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_options);



        Button createItinerary = (Button) findViewById(R.id.createItineraryBtn);
        createItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), CreateItineraryForm.class);
                // Show how to pass information to another activity
//                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
                startActivity(Intent1);
            }
        });



    }
}