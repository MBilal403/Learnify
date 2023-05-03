package com.example.learnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Semester1_Outline extends AppCompatActivity {
    private Button buttonn21;
    private Button buttonn22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester1_outline);
        buttonn21 = findViewById(R.id.button21);
        buttonn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semester1_Outline.this,CourseOutline.class);
                startActivity(intent);
            }
        });
        buttonn22 = findViewById(R.id.button22);
        buttonn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semester1_Outline.this,ICT.class);
                startActivity(intent);
            }
        });
    }
}