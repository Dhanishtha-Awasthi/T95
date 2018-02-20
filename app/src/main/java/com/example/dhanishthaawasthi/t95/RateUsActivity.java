package com.example.dhanishthaawasthi.t95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

    final RatingBar ratingBar = (RatingBar) findViewById(R.id.rate_us);
    Button submit= (Button)findViewById(R.id.submit);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String totalstars = "Total Stars:: "+ ratingBar.getNumStars();
            String rating = "Rating "+ ratingBar.getRating();
            Toast.makeText(getApplicationContext(), totalstars + "\n" + rating, Toast.LENGTH_SHORT).show();
        }
    });


    }

}
