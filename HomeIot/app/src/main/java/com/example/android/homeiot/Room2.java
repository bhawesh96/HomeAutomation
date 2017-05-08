package com.example.android.homeiot;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by MAHE on 10-Oct-16.
 */

public class Room2 extends AppCompatActivity {

    private boolean switchStatus[] = new boolean[4];
    String switch1="0",data1;
    ProgressDialog pDialog;
    ImageView imgView;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        Switch mySwitch1 = (Switch) findViewById(R.id.light1_switch);
        Button mySwitch2 = (Button) findViewById(R.id.secure_switch);
        imgView = (ImageView) findViewById(R.id.secure_data);

        switchStatus[0] = switchStatus[1] = switchStatus[2] = false;
        mySwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    switchStatus[0] = true;
                    switch1 = " 1";
                } else {
                    switchStatus[0] = false;
                    switch1 = " 0";
                }
                try {
                    getText(buttonView);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mySwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new LoadImage().execute("http://cribblservices.esy.es/photo.jpg");
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getText(View view) throws UnsupportedEncodingException {
        data1 = URLEncoder.encode(switch1, "UTF-8");

        String url = "http://cribblservices.esy.es/vedanth/php/room2.php?light1="+data1+"";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Room2.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }

        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                imgView.setImageBitmap(image);
                pDialog.dismiss();

            } else {

                pDialog.dismiss();
                Toast.makeText(Room2.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }
}