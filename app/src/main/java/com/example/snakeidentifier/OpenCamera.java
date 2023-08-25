package com.example.snakeidentifier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
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

public class OpenCamera extends AppCompatActivity {
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 103;


    public  void  backToMain(View view){
        Intent intent = new Intent(OpenCamera.this,MainActivity.class);
        startActivity(intent);
    }

    private Bitmap capturedImage;
    ImageView camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);

        camera = findViewById(R.id.camera_btn);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OpenCamera.this, "Camera Btn is clicked", Toast.LENGTH_SHORT).show();
                askCameraPermissions();
            }

        });
    }


    private void askCameraPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }else{
            openCamera();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, "Camera Permission is required to Use camera", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);
    }



    private class HttpPostAsyncTask extends AsyncTask<Bitmap, Void, String> {

        @Override
        protected String doInBackground(Bitmap... bitmaps) {
            Bitmap imageBitmap = bitmaps[0];
            String response = "";

            try {

                URL url = new URL("https://b7b4-45-121-88-61.ngrok-free.app/"); // Replace with your server URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(byteArray);

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("image", encodedImage);

                DataOutputStream os = new DataOutputStream(connection.getOutputStream());
                os.writeBytes(jsonParam.toString());

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder responseBuilder = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    responseBuilder.append(inputLine);
                }
                in.close();

                response = responseBuilder.toString();

                os.flush();
                os.close();
                connection.disconnect();



            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            openResponseActivity(result,capturedImage);

            // Handle the HTTP response here
            // For example, display the response using a Toast or update UI elements
            // Toast.makeText(MainActivity.this, "Response: " + result, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE){
            capturedImage  = (Bitmap) data.getExtras().get("data");

            // Send the captured image using the HttpPostAsyncTask
            new HttpPostAsyncTask().execute(capturedImage);

        }else if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK){
            // Handle gallery selection
            Uri selectedImageUri = data.getData();
            Bitmap selectedBitmap = getBitmapFromUri(selectedImageUri);

            capturedImage = selectedBitmap;

            new HttpPostAsyncTask().execute(capturedImage);
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void openResponseActivity(String response, Bitmap capturedImage) {

        Intent intent = new Intent(OpenCamera.this, SnakeDetails.class);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        this.capturedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        // Put the image byte array and response as extras
        intent.putExtra("imageByteArray", byteArray);
        intent.putExtra("response", response);
        startActivity(intent);
    }


}