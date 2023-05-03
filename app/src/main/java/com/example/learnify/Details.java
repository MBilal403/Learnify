package com.example.learnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Details extends AppCompatActivity {

    private Button buttonn7;
    private Button buttonn8;
    private Button BtnSignOut;
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
@Override
public void onStart() {
    super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if(currentUser == null){
        Intent intent =new Intent(Details.this, login.class);
        startActivity(intent);
    }else{
        Toast.makeText(Details.this,currentUser.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        buttonn7 = findViewById(R.id.button7);
        buttonn7 = findViewById(R.id.button7);
        BtnSignOut = findViewById(R.id.btnSignOut);
        mAuth = FirebaseAuth.getInstance();

        BtnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent =new Intent(Details.this, login.class);
                startActivity(intent);

            }
        });
        buttonn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this,CourseOutline.class);
                startActivity(intent);
            }
        });
        buttonn8 = findViewById(R.id.button8);
        buttonn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this,CourseMaterial.class);
                startActivity(intent);
            }
        });
    }
}