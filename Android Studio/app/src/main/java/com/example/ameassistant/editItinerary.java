package com.example.ameassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editItinerary extends AppCompatActivity {

    EditText itIdText, itVolIdText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_itinerary);
        itIdText = (EditText) findViewById(R.id.itIdEditText);
        itVolIdText = (EditText) findViewById(R.id.itVolIdEditText);


//        Button findIdButton = (Button) findViewById(R.id.findItBtn);
//        findIdButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String it_id = itIdText.getText().toString();
//                String it_vol_id = itVolIdText.getText().toString();
//                String type = "itinerary"
//                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
//                backgroundWorker.execute(type, it_id, it_vol_id);
//            }
//        });

    }

    public void onEdit(View v){
        String it_id = itIdText.getText().toString();
        String it_vol_id = itVolIdText.getText().toString();
        String type = "itinerary";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, it_id, it_vol_id);
    }
}
