package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_home_page_Activity extends AppCompatActivity {
    private Button eventManagementbtn, userRegbtn, adminlogoutbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page_);

        eventManagementbtn = (Button) findViewById(R.id.event_management_btn);
        userRegbtn = (Button) findViewById(R.id.user_regi_btn);
        adminlogoutbtn = (Button) findViewById(R.id.admin_logout_btn);

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