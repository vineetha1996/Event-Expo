package com.example.event_expo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;

public class Admin_home_page_Activity extends AppCompatActivity {
    private Button eventManagementbtn, userRegbtn, adminlogoutbtn;
    private TextView kayakTV, TennisTV, pettingTV, harvestTV, soccerTV, paintingTV;
    private ImageView kayakIV, tennisIV, pettingIV, harvestIV, soccerIV, paintingIV;


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
        kayakIV = (ImageView) findViewById(R.id.kayakimageView);
        tennisIV = (ImageView) findViewById(R.id.tennisimageView6);
        harvestIV = (ImageView) findViewById(R.id.harvestimageView);
        soccerIV = (ImageView) findViewById(R.id.soccerimageView);
        paintingIV = (ImageView) findViewById(R.id.paintimageView);
        pettingIV = (ImageView) findViewById(R.id.pettingimageView);


        eventManagementbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent managementIntent = new Intent(Admin_home_page_Activity.this, MaintainEventsActivity.class);
                startActivity(managementIntent);
            }
        });


        tennisIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.tennis);
                startActivity(intent);
            }
        });

        harvestIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.harvesting);
                startActivity(intent);
            }
        });

        pettingIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.petting);
                startActivity(intent);
            }
        });

        soccerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.soccer);
                startActivity(intent);
            }
        });

        paintingIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.painting);
                startActivity(intent);
            }
        });

        kayakTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.kayaking);
                startActivity(intent);

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
                SharedPref sharedPref = SharedPref.getInstance();
                sharedPref.clearSharedPref(Admin_home_page_Activity.this);
                Intent intent = new Intent(Admin_home_page_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        kayakIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.kayaking);
                startActivity(intent);
            }
        });

        soccerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.soccer);
                startActivity(intent);

            }
        });

        paintingTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.painting);
                startActivity(intent);

            }
        });

        pettingTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.petting);
                startActivity(intent);

            }
        });

        harvestTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.harvesting);
                startActivity(intent);
            }
        });

        TennisTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_home_page_Activity.this, Add_Event_Activity.class );
                intent.putExtra(Constants.eventType,Constants.tennis);
                startActivity(intent);
            }
        });
    }
}

