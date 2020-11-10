package com.example.event_expo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView adminLoginTV, registerTV, forgotTV;
    private Button loginbtn;
    EditText login_usernameET,login_password_ET;
    String username,email,phn,pass,frstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adminLoginTV = (TextView) findViewById(R.id.adminTV);
        registerTV = (TextView) findViewById(R.id.registerTV);
        loginbtn = (Button) findViewById(R.id.login_btn);
        forgotTV = (TextView) findViewById(R.id.forgotTV);

        login_usernameET=findViewById(R.id.login_usernameET);
        login_password_ET=findViewById(R.id.login_password_ET);

        final Intent intent=getIntent() ;
        username= intent.getStringExtra("USER_name");
        email=intent.getStringExtra("USER_email");
        phn=intent.getStringExtra("USER_phn");
        pass = intent.getStringExtra("USER_pass");
        frstname = intent.getStringExtra("USER_Frstname");
        lastname = intent.getStringExtra("USER_Lastname");

        Log.d("Login activity", username+frstname+lastname+email+phn+pass);

//        Intent intent=getIntent() ;
//        final String   fullname= intent.getStringExtra("USER_name");
//        String  email=intent.getStringExtra("USER_email");
//        String  phn=intent.getStringExtra("USER_phn");
//        final String  pass=intent.getStringExtra("USER_pass");
//
//        Log.d("suma", fullname+email+phn+pass);

        adminLoginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(LoginActivity.this,
                        Admin_login_Activity.class);
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


                if(username.equals(login_usernameET.getText().toString())&& pass.equals(login_password_ET.getText().toString())){

//
//                if(fullname.equals(login_usernameET.getText().toString()) && pass.equals(login_password_ET.getText().toString())){


                    Intent loginIntent = new Intent(LoginActivity.this, UserMaintenanceActivity.class);
                    loginIntent.putExtra("loname", username);
                    loginIntent.putExtra("loemail", email);
                    loginIntent.putExtra("lophone", phn);
                    loginIntent.putExtra("loFrstname", frstname);
                    loginIntent.putExtra("loLastname", lastname);
                    loginIntent.putExtra("lopassword", pass);
                    Log.d("Login activity", username+frstname+lastname+email+phn+pass);

                    startActivity(loginIntent);
                }
                else{

                    Toast.makeText(getApplicationContext(), "Username and Password are incorrect", Toast.LENGTH_SHORT).show();

                    Toast.makeText(getApplicationContext(),"Enter registered username and password",Toast.LENGTH_SHORT).show();

                }
            }
        });


//
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(fullname.equals(login_usernameET.getText().toString())&& pass.equals(login_password_ET.getText().toString())){
//
//                    Intent loginIntent = new Intent(LoginActivity.this, UserMaintenanceActivity.class);
//                    startActivity(loginIntent);
//                }
//                else{
//                }
//            }
//        });
        forgotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(forgotIntent);
            }
        });
    }
}