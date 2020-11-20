package com.example.event_expo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.model.User;
import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    private TextView adminLoginTV, registerTV, forgotTV;
    private Button loginbtn;
    private FirebaseFirestore db;
    EditText login_usernameET,login_password_ET;
    String username,email,phn,pass,frstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = FirebaseFirestore.getInstance();

        SharedPref sharedPref = SharedPref.getInstance();
        String loginType = sharedPref.isLoggedIn(this);
        if (!loginType.isEmpty()){
            Intent intent;
            if (loginType.equals(Constants.admin)){
                intent = new Intent(this,Admin_home_page_Activity.class);
            }else{
                intent = new Intent(this,UserMaintenanceActivity.class);
            }
            startActivity(intent);
            finish();
        }

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
                String username = login_usernameET.getText().toString();
                String password = login_password_ET.getText().toString();

                if (!validateInputs(username,password)) return;

                loginUser(username,password);
            }
        });

        forgotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgotIntent);
            }
        });
    }

    private boolean validateInputs(String username,String password){
        if (username.isEmpty()){
            Toast.makeText(this, getString(R.string.username_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()){
            Toast.makeText(this, getString(R.string.password_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void loginUser(String username,String password){

        db.collection(Constants.user)
                .whereEqualTo(Constants.username,username)
                .whereEqualTo(Constants.password,password)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            if (task.getResult().size()==1){
                                SharedPref sharedPref = SharedPref.getInstance();
                                sharedPref.setLoginType(LoginActivity.this,Constants.user);
                                sharedPref.setUserDocumentID(LoginActivity.this,task.getResult().getDocuments().get(0).getId());
                                sharedPref.setUser(LoginActivity.this,task.getResult().getDocuments().get(0).toObject(User.class));
                                Intent loginIntent = new Intent(LoginActivity.this, UserMaintenanceActivity.class);
                                startActivity(loginIntent);
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, getString(R.string.wrong_credentials), Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this,getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

}