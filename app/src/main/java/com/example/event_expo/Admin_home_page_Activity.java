package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_home_page_Activity extends AppCompatActivity {
    private Button eventManagementbtn, userRegbtn, adminlogoutbtn;
    private TextView kayakTV, TennisTV, pettingTV, harvestTV, soccerTV, paintingTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page_);

        eventManagementbtn = (Button) findViewById(R.id.event_management_btn);
        userRegbtn = (Button) findViewById(R.id.user_regi_btn);
        adminlogoutbtn = (Button) findViewById(R.id.admin_logout_btn);
        kayakTV = (TextView) findViewById(R.id.kayakTV);
        TennisTV = (TextView) findViewById(R.id.tennisTV);
        harvestTV = (TextView) findViewById(R.id.harvestinggTV);
        soccerTV = (TextView) findViewById(R.id.soccerTV);
        paintingTV = (TextView) findViewById(R.id.paintingTV);
        pettingTV = (TextView) findViewById(R.id.pettingTV);


        eventManagementbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent managementIntent = new Intent(Admin_home_page_Activity.this, MaintainEventsActivity.class);
                startActivity(managementIntent);

            }
        });

        userRegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(Admin_home_page_Activity.this,RegisterEventsActivity.class);
                startActivity(userIntent);

            }
        });

        adminlogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });








    }
}