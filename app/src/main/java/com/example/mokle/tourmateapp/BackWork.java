package com.example.mokle.tourmateapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by MOKLESUR RAHMAN on 10/1/2017.
 */

public class BackWork extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    public BackWork(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String type= "reg";
        String rUrl = "http://localhost/reg.php";

        if(type.equals("reg")){
            try {
                String imageByte = params[1];
                String name = params[2];
                String email = params[3];
                String userName = params[4];
                String password = params[5];
                String contact = params[6];
                String address = params[7];

                URL url = new URL(rUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData = URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8")+URLEncoder.encode("userName","UTF-8") + "=" + URLEncoder.encode(userName,"UTF-8")+URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");

            }catch (Exception e){

            }
        }


        return null;
    }
}
