package com.example.learnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class CourseOutline extends AppCompatActivity {
    private Button buttonn9;
    private Button buttonn10;
    private Button buttonn11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_outline);
        buttonn9 = findViewById(R.id.button9);
        buttonn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseOutline.this,Details.class);
                startActivity(intent);
            }
        });
        buttonn10 = findViewById(R.id.button10);
        buttonn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseOutline.this,Semester1_Outline.class);
                startActivity(intent);
            }
        });
        buttonn11 = findViewById(R.id.button11);
        buttonn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseOutline.this,Semester2_Outline.class);
                startActivity(intent);
            }
        });
    }
}