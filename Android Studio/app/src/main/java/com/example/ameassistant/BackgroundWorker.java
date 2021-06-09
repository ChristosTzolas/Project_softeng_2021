package com.example.ameassistant;

import android.app.AlertDialog;
import android.content.Context;
import android.icu.util.Output;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        String type = voids[0];
        String create_itinerary_url = "http://10.0.2.2/createItinerary.php";
        String itinerary_url = "http://10.0.2.2/itinerary.php";
        if(type.equals("itinerary")){
            try {
                String it_id = voids[1];
                String it_vol_id = voids[2];
                URL url = new URL(itinerary_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("it_id", "UTF-8")+"="+URLEncoder.encode(it_id, "UTF-8")+"&"+
                        URLEncoder.encode("it_vol_id", "UTF-8")+"="+URLEncoder.encode(it_vol_id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine())!= null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("createItinerary")){
            try {
                String it_vol_id = voids[0];
                String date_and_time = voids[1];
                String location = voids[2];
                String to_or_from = voids[3];
                String num_seats = voids[4];
                URL url = new URL(create_itinerary_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("it_vol_id", "UTF-8")+"="+URLEncoder.encode(it_vol_id, "UTF-8")+"&"+
                        URLEncoder.encode("date_and_time", "UTF-8")+"="+URLEncoder.encode(date_and_time, "UTF-8")+"&"+
                        URLEncoder.encode("location", "UTF-8")+"="+URLEncoder.encode(location, "UTF-8")+"&"+
                        URLEncoder.encode("to_or_from", "UTF-8")+"="+URLEncoder.encode(to_or_from, "UTF-8")+"&"+
                        URLEncoder.encode("num_seats", "UTF-8")+"="+URLEncoder.encode(num_seats, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine())!= null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Itinerary find status");
    }

    @Override
    protected void onPostExecute(String result) {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context).setTitle("Itinerary Find status...");
//        alertDialogBuilder.setMessage(result);
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
        alertDialog.setMessage(result);
        alertDialog.show();
//        this.statusField.setText("Login Successful");
//        this.roleField.setText(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
