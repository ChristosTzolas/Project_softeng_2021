package com.example.ameassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if (getIntent().hasExtra("com.example.ameassistant.SOMETHING")){
//            TextView tv = (TextView) findViewById(R.id.textViewfrommain);
//            String text = getIntent().getExtras().getString("com.example.ameassistant.SOMETHING");
//            tv.setText(text);
        }

        Button addEventBtn = (Button) findViewById(R.id.addEventBtn);
        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), CreateEventForm.class);
                // Show how to pass information to another activity
//                Intent1.putExtra("com.example.ameassistant.SOMETHING", "Hello World!!!");
                startActivity(Intent1);
            }
        });

    }
}