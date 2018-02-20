package com.example.dhanishthaawasthi.t95;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       img = (ImageView)findViewById(R.id.imageView4);


          //  final Animation  animation1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.firstscreen);
       // final Animation  animation2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.antirotate);
        final Animation  animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        img.startAnimation(animation3);

        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
             img.startAnimation(animation3);
             finish();
             Intent intent = new Intent(MainActivity.this,Login_menu_activity.class);
             startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
