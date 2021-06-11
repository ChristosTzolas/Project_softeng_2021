package com.example.ameassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItineraryConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_confirmation);


        Button confirmItinBtn = (Button) findViewById(R.id.confirmItinBtn);
        confirmItinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Intent1);
            }
        });
    }
}