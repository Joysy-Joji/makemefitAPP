package com.example.app_makemefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button shoulder,theghes,abdomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        shoulder=(Button)findViewById(R.id.button);
        abdomen=(Button)findViewById(R.id.button2);
        theghes=(Button) findViewById(R.id.button3);

        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(home.this, shoulder_execise.class);
                startActivity(d);
            }
        });
        abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(home.this, abdomen_exercise.class);
                startActivity(d);
            }
        });
        theghes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(home.this, theghes_execise.class);
                startActivity(d);
            }
        });

    }
}