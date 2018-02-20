package com.example.dhanishthaawasthi.t95;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Login_menu_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu_activity);


        Intent intent = getIntent();

        Button slogin = (Button) findViewById(R.id.sbutton);
        Button elogin = (Button) findViewById(R.id.ebutton);

        slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLoginAtivity = new Intent(Login_menu_activity.this, Login_activity.class);
                startActivity(intentToLoginAtivity);
            }
        });

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Login_menu_activity.this, Login_activity_employee.class);
                startActivity(intent1);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int iditemClicked = item.getItemId();
        if (iditemClicked == R.id.item_about) {
            Intent intenttoabout = new Intent(Login_menu_activity.this, AboutActivity.class);
            startActivity(intenttoabout);
            return true;
        }
        if (iditemClicked == R.id.item_rateus) {

            Intent intenttorate = new Intent(Login_menu_activity.this, RateUsActivity.class);
            startActivity(intenttorate);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}