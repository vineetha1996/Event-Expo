package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {
    EditText userfirstname,userlastname,mobilenumber,useremail;
    String u_name,u_email,u_phn,u_pass,u_frstname,u_lastname;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        useremail = findViewById(R.id.user_emailTV);
        mobilenumber = findViewById(R.id.mob_numTV);
        userfirstname = findViewById(R.id.first_nameTV);
        userlastname = findViewById(R.id.last_nameTV);
        submit = findViewById(R.id.submit_btn);

        //getting the passed values from userMaintenace activity.
        Intent intent=getIntent() ;
        u_email =intent.getStringExtra("u_email");
        u_phn = intent.getStringExtra("u_phone");
        u_frstname = intent.getStringExtra("u_Frstname");
        u_lastname = intent.getStringExtra("u_Lastname");


        Log.d("profile",u_frstname+u_lastname+ u_phn+u_email);
        userfirstname.setText(u_frstname);
        userlastname.setText(u_lastname);
        mobilenumber.setText(u_phn);
        useremail.setText(u_email);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
            }
        });













    }
}