package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserMaintenanceActivity extends AppCompatActivity {

    private TextView homieTV,profileTV,orderHistoryTV, aboutTV;
    private Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_maintenance);


        profileTV = (TextView) findViewById(R.id.profileTV);
        orderHistoryTV = (TextView) findViewById(R.id.order_historyTV);
        logoutbtn = (Button) findViewById(R.id.logout_btn);
        aboutTV = (TextView) findViewById(R.id.aboutappTV);
        homieTV = (TextView) findViewById(R.id.homeTV);

        homieTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(UserMaintenanceActivity.this,UserHomeActivity);
                startActivity(homeIntent);
            }
        });



        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(UserMaintenanceActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
            }
        });

        orderHistoryTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(UserMaintenanceActivity.this, OrderHistoryActivity.class);
                startActivity(historyIntent);
            }
        });

        profileTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(UserMaintenanceActivity.this, UserProfileActivity.class);
                startActivity(historyIntent);
            }
        });

        aboutTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(UserMaintenanceActivity.this, AboutAppActivity.class);
                startActivity(historyIntent);
            }
        });


    }
}