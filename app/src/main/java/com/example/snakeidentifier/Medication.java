package com.example.snakeidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Medication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        getSupportActionBar().hide();

        TextView descriptionText1 = findViewById(R.id.textViewDescription1);
        TextView descriptionText2 = findViewById(R.id.textViewDescription2);


        descriptionText1.setText("• Keep the bitten person still and calm.\n\n" +
                "• Wash the wound immediately with running   water.\n\n" +
                "• Rush the patient to the nearest Government   hospital within 45 minutes to an " +
                "  hour.\n\n" +
                "• Drink plenty of fluids to stay hydrated. Avoid   alcohol and caffeine");


        descriptionText2.setText("• Apply a tourniquet or tight bandage above the   bite site. \n\n" +
                "• Apply ice directly to the bite area.");

    }

}