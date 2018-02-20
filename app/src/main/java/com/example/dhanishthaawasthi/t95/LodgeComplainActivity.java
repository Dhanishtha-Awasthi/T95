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

public class LodgeComplainActivity extends AppCompatActivity {

    ImageView lodgeComplaintImageView;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodge_complain);

        lodgeComplaintImageView = (ImageView) findViewById(R.id.iv_lodge_complaint);

        gestureDetectorCompat = new GestureDetectorCompat(this,new MyLodgeGestureListener());
        lodgeComplaintImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToLodgeComplaint = new Intent(LodgeComplainActivity.this,LodgeComplaintDetails.class);
                startActivity(intentToLodgeComplaint);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class MyLodgeGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {

            if(e2.getX()>e1.getX())
            {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
            return true;
        }
    }
}
