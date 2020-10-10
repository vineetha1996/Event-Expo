package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView adminLoginTV, registerTV, forgotTV;
    private Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        adminLoginTV = (TextView) findViewById(R.id.adminTV);
        registerTV = (TextView) findViewById(R.id.registerTV);
        loginbtn = (Button) findViewById(R.id.login_btn);
        forgotTV = (TextView) findViewById(R.id.forgotTV);

        adminLoginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(LoginActivity.this,Admin_login_Activity.class);
                startActivity(adminIntent);
            }
        });

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regiIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(regiIntent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(LoginActivity.this, UserMaintenanceActivity.class);
                startActivity(loginIntent);
            }
        });

        forgotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(forgotIntent);
            }
        });

    }

}