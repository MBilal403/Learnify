package com.example.learnify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Semester2_Outline extends AppCompatActivity {
    private Button buttonn28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester2_outline);
        buttonn28 = findViewById(R.id.button28);
        buttonn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semester2_Outline.this,CourseOutline.class);
                startActivity(intent);
            }
        });
    }
}