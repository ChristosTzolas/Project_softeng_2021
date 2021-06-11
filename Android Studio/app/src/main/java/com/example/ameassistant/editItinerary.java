package com.example.ameassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class editItinerary extends AppCompatActivity {

//    EditText itIdText, itVolIdText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_itinerary);
//        itIdText = (EditText) findViewById(R.id.itIdEditText);
//        itVolIdText = (EditText) findViewById(R.id.itVolIdEditText);


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

        String data[][], receivedData = "";
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
//        String it_id = itIdText.getText().toString();
//        int int_it_id = Integer.parseInt(itIdText.getText().toString());
//        String it_id = String.valueOf(int_it_id);
//        String it_vol_id = itVolIdText.getText().toString();
        String type = "itinerary";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        try {
            receivedData = backgroundWorker.execute(type).get();
            jsonArray = new JSONArray(receivedData);
            data = new String[jsonArray.length()][];
            String it_idss[] = new String[jsonArray.length()];
            String it_vol_idss[] = new String[jsonArray.length()];
            String date_and_timess[] = new String[jsonArray.length()];
            String locationsss[] = new String[jsonArray.length()];
            String to_or_fromss[] = new String[jsonArray.length()];
            String num_seatsss[] = new String[jsonArray.length()];
            for (int i=0; i<jsonArray.length(); i++){
                data[i] = new String[jsonArray.length()];
               // String[]  it_vol_idss, date_and_timess , locationsss, to_or_fromss, num_seatsss;
                jsonObject = jsonArray.getJSONObject(i);
                it_idss[i] = jsonObject.getString("it_id"); // column name
                it_vol_idss[i] = jsonObject.getString("it_vol_id"); // column name
                date_and_timess[i] = jsonObject.getString("date_and_time"); // column name
                locationsss[i] = jsonObject.getString("locations"); // column name
                to_or_fromss[i] = jsonObject.getString("to_or_from"); // column name
                num_seatsss[i] = jsonObject.getString("num_seats"); // column name
            }
            addView(it_idss, it_vol_idss, date_and_timess,locationsss,to_or_fromss,num_seatsss);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addView(String[] it_id, String[] it_vol_id, String[] date_and_time, String[] locations, String[] to_or_from, String[] num_seats) {
        ListView myListView ;
        myListView = (ListView) findViewById(R.id.myListView);
        View v = getLayoutInflater().inflate(R.layout.my_listview_detail, null, false);

        ItemAdapter itemAdapter = new ItemAdapter(this, it_id, it_vol_id, date_and_time, locations, to_or_from, num_seats);
        myListView.setAdapter(itemAdapter);
    }
}
