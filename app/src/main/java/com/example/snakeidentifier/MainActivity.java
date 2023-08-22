package com.example.snakeidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public  void  openVenomousSnake(View view){
        Intent intent = new Intent(MainActivity.this,VenomuousSnakes.class);
        startActivity(intent);
    }

    public  void  openNonVenomousSnake(View view){
        Intent intent = new Intent(MainActivity.this,NonVenomousSnakes.class);
        startActivity(intent);
    }
    public  void  openSnakeCatchers(View view){
        Intent intent = new Intent(MainActivity.this,SnakeCatchers.class);
        startActivity(intent);
    }

    public  void  openMedication(View view){
        Intent intent = new Intent(MainActivity.this,Medication.class);
        startActivity(intent);
    }

    public  void  openHospitals(View view){
        Intent intent = new Intent(MainActivity.this,Hospitals.class);
        startActivity(intent);
    }
}