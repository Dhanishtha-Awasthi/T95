package com.example.dhanishthaawasthi.t95;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EmployeeWorklogActivity extends AppCompatActivity {

    ImageView worklogImageView;
    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_worklog);

        worklogImageView = (ImageView) findViewById(R.id.iv_employee_worklog);

        gestureDetectorCompat = new GestureDetectorCompat(this,new MyEmployeeGestureListener());

        worklogImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToWorklogDetails = new Intent(EmployeeWorklogActivity.this,ViewRecordDetailsActivity.class);
                startActivity(intentToWorklogDetails);
            }
        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyEmployeeGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if(e2.getX() < e1.getX())
            {
                Intent intentToViewRecords = new Intent(EmployeeWorklogActivity.this,LodgeComplainActivity.class);
                startActivity(intentToViewRecords);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
            return true;
        }
    }
}
