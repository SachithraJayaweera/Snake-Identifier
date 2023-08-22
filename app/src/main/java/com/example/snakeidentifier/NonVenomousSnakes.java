package com.example.snakeidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NonVenomousSnakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_venomous_snakes);
        getSupportActionBar().hide();

    }

    public  void  backToMain(View view){
        Intent intent = new Intent(NonVenomousSnakes.this,MainActivity.class);
        startActivity(intent);
    }
}