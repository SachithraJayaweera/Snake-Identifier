package com.example.snakeidentifier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void onBackPressed() {

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit from the app?")
                .setCancelable(false)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
    public  void  goToCamera(View view){
        Intent intent = new Intent(MainActivity.this,OpenCamera.class);
        startActivity(intent);
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