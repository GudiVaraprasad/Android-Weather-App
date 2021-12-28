package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        b2 = (Button) findViewById(R.id.button2);
        b1 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingApp();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tfhPage();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                about();
            }
        });
    }

    private void ratingApp() {
        Intent intent = new Intent(this, RatingApp.class);
        startActivity(intent);
    }

    private void tfhPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void about() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.about))
                .setMessage(getString(R.string.about_text))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}