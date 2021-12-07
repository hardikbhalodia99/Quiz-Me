package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       start =findViewById(R.id.startbutton);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent screenActivity = new Intent(getApplicationContext(), screenActivity.class);
                    startActivity(screenActivity);


            }
        });

    }
}