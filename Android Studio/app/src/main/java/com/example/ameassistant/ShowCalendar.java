package com.example.ameassistant;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if (getIntent().hasExtra("com.example.ameassistant.SOMETHING")){
            TextView tv = (TextView) findViewById(R.id.textViewfrommain);
            String text = getIntent().getExtras().getString("com.example.ameassistant.SOMETHING");
            tv.setText(text);
        }


    }
}