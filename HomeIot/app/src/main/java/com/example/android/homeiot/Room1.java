package com.example.android.homeiot;

/**
 * Created by MAHE on 10-Oct-16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Room1 extends AppCompatActivity {

    private boolean switchStatus[] = new boolean[4];
    String switch1="0",data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);

        Switch mySwitch1 = (Switch) findViewById(R.id.light1_switch);
        Button mySwitch2 = (Button) findViewById(R.id.temp_switch);
        Button mySwitch3 = (Button) findViewById(R.id.moist_switch);
        TextView txt1 = (TextView) findViewById(R.id.temp_data);
        TextView txt2 = (TextView) findViewById(R.id.moist_data);

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
                    Toast.makeText(getApplicationContext(), "There seems to be some problem!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mySwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getText2(v);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mySwitch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getText3(v);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void getText(View view) throws UnsupportedEncodingException {
        data1 = URLEncoder.encode(switch1, "UTF-8");

        String url = "http://cribblservices.esy.es/vedanth/php/room1.php?light1="+data1+"";
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

    public void getText2(View view) throws UnsupportedEncodingException {
        data1 = URLEncoder.encode(switch1, "UTF-8");

        String url = "http://cribblservices.esy.es/vedanth/php/temp.txt";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView t = (TextView) findViewById(R.id.temp_data);
                        t.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    public void getText3(View view) throws UnsupportedEncodingException {
        data1 = URLEncoder.encode(switch1, "UTF-8");

        String url = "http://cribblservices.esy.es/vedanth/php/moisture.txt";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView t = (TextView) findViewById(R.id.moist_data);
                        t.setText(response);
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

}