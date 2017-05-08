package com.example.android.homeiot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView room1  = (TextView) findViewById(R.id.room1);
        room1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent room1Intent = new Intent(Login.this, Room1.class);
                startActivity(room1Intent);
            }
        });

        TextView room2  = (TextView) findViewById(R.id.room2);
        room2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent room2Intent = new Intent(Login.this, Room2.class);

                // Start the new activity
                startActivity(room2Intent);
            }
        });

        TextView hall = (TextView) findViewById(R.id.hall);
        hall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent hallIntent = new Intent(Login.this, Hall.class);

                // Start the new activity
                startActivity(hallIntent);
            }
        });

    }
}