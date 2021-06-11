package com.example.ameassistant;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.concurrent.TimeUnit;

public class EmergencyButton extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String location = "no location given";
        if (getIntent().hasExtra("com.example.ameassistant.SOMETHING")){
             location = getIntent().getExtras().getString("com.example.ameassistant.SOMETHING");
        }


        setContentView(R.layout.activity_emergency_button);
        Intent Intent1 = new Intent(getApplicationContext(), MainActivity.class);
        Handler handler = new Handler();
        String finalLocation = location;
        handler.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void run() {




                String smsNumber = "00306912345678";
                String smsText = "Need help! I have fallen off the wheelchair at location: "+ finalLocation;
                Uri uri = Uri.parse("smsto:" + smsNumber);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", smsText);
                startActivity(intent);
            }
        }, 5000);   //5 seconds




    }
}