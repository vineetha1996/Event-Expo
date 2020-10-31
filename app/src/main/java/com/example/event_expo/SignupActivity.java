package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {


   EditText user_nameTV,user_emailTV,mobile_numTV,user_passwordTV,user_compassTV,user_Fullname;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user_nameTV=findViewById(R.id.user_nameTV);
        user_emailTV=findViewById(R.id.user_emailTV);
        mobile_numTV=findViewById(R.id.mobile_numTV);
        user_passwordTV=findViewById(R.id.user_passwordTV);
        user_compassTV=findViewById(R.id.user_compassTV);
        user_Fullname = findViewById(R.id.user_Fullname);
        submit_btn=findViewById(R.id.submit_btn);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username=    user_nameTV.getText().toString();
               // String email=    user_nameTV.getText().toString();
                String email=    user_emailTV.getText().toString();
                String number=    mobile_numTV.getText().toString();
                String password=    user_passwordTV.getText().toString();
                String confirm=    user_compassTV.getText().toString();
                String fullname=    user_Fullname.getText().toString();
                String[] arr=fullname.split(" ");

                String frstname=arr[0];
                String lastname=arr[1];

                Log.d("First name",frstname);
                Log.d("last name",lastname);

                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                intent.putExtra("USER_name", username);
                intent.putExtra("USER_email", email);
                intent.putExtra("USER_phn", number);
                intent.putExtra("USER_Frstname", frstname);
                intent.putExtra("USER_Lastname", lastname);
                intent.putExtra("USER_pass", password);
                startActivity(intent);
            }
        });


    }
}