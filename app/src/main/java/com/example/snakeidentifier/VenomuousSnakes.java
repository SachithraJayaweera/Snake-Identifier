package com.example.snakeidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VenomuousSnakes extends AppCompatActivity {


  String Russell_Viper = "Russell's Viper";
  String Nagaya = "Nagaya";
  String dhunuKarawalaya = "dhunuKarawalaya";
  String veliPolanga = "veliPolanga";
  String thelKarawalaya = "thelKarawalaya";
  String humpNoseViper = "humpNoseViper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venomuous_snakes);
        getSupportActionBar().hide();
    }

    public  void  backToMain(View view){
        Intent intent = new Intent(VenomuousSnakes.this,MainActivity.class);
        startActivity(intent);
    }

    public  void   tithPolanga(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", Russell_Viper);
        startActivity(intent);
    }

    public  void  nagaya(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", Nagaya);
        startActivity(intent);
    }

    public  void  dhunuKarawalaya(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", dhunuKarawalaya);
        startActivity(intent);
    }

    public  void  veliPolanga(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", veliPolanga);
        startActivity(intent);
    }

    public  void  thelKarawalaya(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", thelKarawalaya);
        startActivity(intent);
    }

    public  void  humpNoseViper(View view){
        Intent intent = new Intent(VenomuousSnakes.this,SnakeDetails.class);
        intent.putExtra("snakeName", humpNoseViper);
        startActivity(intent);
    }



}