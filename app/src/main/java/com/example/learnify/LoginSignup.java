package com.example.learnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginSignup extends AppCompatActivity {

    private Button buttonn;
    private Button buttonn2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        buttonn = findViewById(R.id.button2);
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSignup.this,Signup.class);
                startActivity(intent);
            }
        });
        buttonn2 = findViewById(R.id.button);
        buttonn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSignup.this,login.class);
                startActivity(intent);
            }
        });


    }
}