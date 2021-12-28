package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_app);

        RatingBar mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
        EditText mFeedback = (EditText) findViewById(R.id.etFeedback);
        Button mSendFeedback = (Button) findViewById(R.id.btnSubmit);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Did not Like it!");
                        break;
                    case 2:
                        mRatingScale.setText("Need some Improvement!");
                        break;
                    case 3:
                        mRatingScale.setText("Good!");
                        break;
                    case 4:
                        mRatingScale.setText("Great!");
                        break;
                    case 5:
                        mRatingScale.setText("Awesome. Very Helpful!");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });

        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(RatingApp.this, "Please fill in feedback!", Toast.LENGTH_LONG).show();
                } else {
                    mFeedback.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(RatingApp.this, "Thanks for rating the app!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}