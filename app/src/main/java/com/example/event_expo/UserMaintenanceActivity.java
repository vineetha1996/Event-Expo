package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserMaintenanceActivity extends AppCompatActivity {

    private TextView homieTV,profileTV,orderHistoryTV, aboutTV;
    private Button logoutbtn;
    String name,emailid,phone,password,firstname,lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_maintenance);


        profileTV = (TextView) findViewById(R.id.profileTV);
        orderHistoryTV = (TextView) findViewById(R.id.order_historyTV);
        logoutbtn = (Button) findViewById(R.id.logout_btn);
        aboutTV = (TextView) findViewById(R.id.aboutappTV);
        homieTV = (TextView) findViewById(R.id.homeTV);

        final Intent intent=getIntent() ;
        name = intent.getStringExtra("loname");
        emailid=intent.getStringExtra("loemail");
        phone=intent.getStringExtra("lophone");
        password = intent.getStringExtra("lopassword");
        firstname = intent.getStringExtra("loFrstname");
        lastname = intent.getStringExtra("loLastname");

        Log.d("maintaince",name+emailid);

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
                //navigating values from userMaintenanceActivity to userProfileActivity
                historyIntent.putExtra("u_name", name);
                historyIntent.putExtra("u_email", emailid);
                historyIntent.putExtra("u_phone", phone);
                historyIntent.putExtra("u_Frstname", firstname);
                historyIntent.putExtra("u_Lastname", lastname);
                historyIntent.putExtra("u_password", password);
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
    public void moveToOther(View v){
        Intent ii=new Intent(this,UserHomeActivity.class);
        startActivity(ii);
    }
}