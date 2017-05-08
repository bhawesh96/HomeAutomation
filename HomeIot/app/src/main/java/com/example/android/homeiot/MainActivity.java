package com.example.android.homeiot;

        import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String pwd = "12345";
    String username = "saksham";
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText field1 = (EditText) findViewById(R.id.username);
                user = field1.getText().toString();
                EditText field2 = (EditText) findViewById(R.id.password);
                pass = field2.getText().toString();

                if (user.equals(username) && pass.equals(pwd)) {
                    Intent enterIntent = new Intent(MainActivity.this, Login.class);
                    startActivity(enterIntent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
            }
        });


    }
}