package com.example.dhanishthaawasthi.t95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_activity_employee extends AppCompatActivity {


    String uname;
    String pass;
    EditText textUserName, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);

        Button login = (Button) findViewById(R.id.login);
        textUserName = (EditText) findViewById(R.id.username);
        textPassword = (EditText) findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = textUserName.getText().toString();
                String password = textPassword.getText().toString();
                String type= "login";
                BackgroundWorkerEmployee backgroundWorker1 = new BackgroundWorkerEmployee(Login_activity_employee.this);
                backgroundWorker1.execute(type,username,password);

                Intent intent = new Intent(Login_activity_employee.this,EnterRecordActivity.class);
                startActivity(intent);

            }
        });


    }
}