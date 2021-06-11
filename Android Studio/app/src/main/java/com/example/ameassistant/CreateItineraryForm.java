package com.example.ameassistant;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CreateItineraryForm extends AppCompatActivity {
    EditText it_vol_id, date_and_time, locations,to_or_from, num_seats;
    String str_it_vol_id="7", str_date_and_time, str_locations, str_to_or_from, str_num_seats;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    TextView timerTextView;
    int tHour, tMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        it_vol_id = "7";
        locations = (EditText) findViewById(R.id.locationItineraryFormText);
        num_seats = (EditText) findViewById(R.id.numSeatsItineraryFormText);
        setContentView(R.layout.activity_create_itinerary_form);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        timerTextView = findViewById(R.id.timerTextView);

        timerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        CreateItineraryForm.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                tHour = hourOfDay;
                                tMinute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,tHour,tMinute);
                                timerTextView.setText(DateFormat.format("HH:mm", calendar));
                            }
                        },12,0,false
                );
                timePickerDialog.updateTime(tHour,tMinute);
                timePickerDialog.show();
            }
        });

//        ToggleButton toOrFromBtn = (ToggleButton) findViewById(R.id.toOrFromBtn);
//        if(toOrFromBtn.isChecked()){
//            str_to_or_from = "CENTER";
//        }else{
//            str_to_or_from = "UNI";
//        }
////        date_and_time = dateButton;

        Button submitItineraryFormBtn = (Button) findViewById(R.id.submitItineraryFormBtn);
        submitItineraryFormBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(getApplicationContext(), ItineraryConfirmation.class);
                startActivity(Intent1);
            }
        });

    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return year+"-"+month+"-" + day;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

    public void OnCreateInt(View v){
        locations = (EditText) findViewById(R.id.locationItineraryFormText);
        num_seats = (EditText) findViewById(R.id.numSeatsItineraryFormText);
        dateButton = findViewById(R.id.datePickerButton);
        timerTextView = findViewById(R.id.timerTextView);
        String str_to_or_from;
        String str_locations = locations.getText().toString();
        String str_num_seats = num_seats.getText().toString();
//        int int_num_seats = Integer.parseInt(num_seats.getText().toString());
        String date = dateButton.getText().toString();
        String time = timerTextView.getText().toString();
        String str_date_and_time = date+" "+time+":00";
        ToggleButton toOrFromBtn = (ToggleButton) findViewById(R.id.toOrFromBtn);
        if(toOrFromBtn.isChecked()){
            str_to_or_from = "CENTER";
        }else{
            str_to_or_from = "UNI";
        }
        String type = "createItinerary";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_locations,str_num_seats); // str_it_vol_id,  str_date_and_time, str_to_or_from,
    }



}

