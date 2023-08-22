package com.example.snakeidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hospitals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        getSupportActionBar().hide();
    }

    public  void  backToMain(View view){
        Intent intent = new Intent(Hospitals.this,MainActivity.class);
        startActivity(intent);
    }
}