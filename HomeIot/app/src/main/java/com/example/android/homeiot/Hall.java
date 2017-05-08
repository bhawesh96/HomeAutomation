package com.example.android.homeiot;

/**
 * Created by MAHE on 10-Oct-16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Hall extends AppCompatActivity {

    private boolean switchStatus[] = new boolean[4];
    String switch1="0", switch2="0", switch3="0", data1, data2, data3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall);

        Switch mySwitch1 = (Switch) findViewById(R.id.light1_switch);
        Switch mySwitch2 = (Switch) findViewById(R.id.light2_switch);
        Switch mySwitch3 = (Switch) findViewById(R.id.fan_switch);

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
                    getText();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "There seems to be some problem!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    switchStatus[1] = true;
                    switch2 = " 1";
                } else {
                    switchStatus[1] = false;
                    switch2 = " 0";
                }
                try {
                    getText();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "There seems to be some problem!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    switchStatus[2] = true;
                    switch3 = " 1";
                } else {
                    switchStatus[2] = false;
                    switch3 = " 0";
                }
                try {
                    getText();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "There seems to be some problem!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getText() throws UnsupportedEncodingException {

        data1 = URLEncoder.encode(switch1, "UTF-8");
        data2 = URLEncoder.encode(switch2, "UTF-8");
        data3 = URLEncoder.encode(switch3, "UTF-8");

        String url = "http://cribblservices.esy.es/vedanth/php/hall.php?light1="+data1+"&light2="+data2+"&fan="+data3+"&door=2";
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

}