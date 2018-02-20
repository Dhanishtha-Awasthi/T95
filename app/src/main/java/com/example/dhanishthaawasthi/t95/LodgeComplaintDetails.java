package com.example.dhanishthaawasthi.t95;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LodgeComplaintDetails extends AppCompatActivity {

      EditText complain,workername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodge_complaint_details);

        complain= (EditText) findViewById(R.id.complaint);
        workername = (EditText) findViewById(R.id.workername);


        Button btnldg = (Button)findViewById(R.id.btn_lodge);

        btnldg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String complaint = complain.getText().toString();
                String wname = workername.getText().toString();
                String type= "login";
                BackgroundWorker2 backgroundWorker2 = new BackgroundWorker2(LodgeComplaintDetails.this);
                backgroundWorker2.execute(type,complaint,wname);

            }
        });
    }
}

