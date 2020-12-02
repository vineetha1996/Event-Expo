package com.example.event_expo;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.model.User;
import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.example.event_expo.other.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class SignupActivity extends AppCompatActivity {

   EditText user_nameTV,user_emailTV,mobile_numTV,user_passwordTV,user_compassTV,user_fnameTV, user_lnameTV;
    Button submit_btn;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = FirebaseFirestore.getInstance();

        user_nameTV=findViewById(R.id.user_nameTV);
        user_emailTV=findViewById(R.id.user_emailTV);
        mobile_numTV=findViewById(R.id.mobile_numTV);
        user_passwordTV=findViewById(R.id.user_passwordTV);
        user_compassTV=findViewById(R.id.user_compassTV);
        user_fnameTV = findViewById(R.id.user_fnameTV);
        user_lnameTV = findViewById(R.id.user_lnameTV);
        submit_btn=findViewById(R.id.submit_btn_sign_up);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username=    user_nameTV.getText().toString();
               // String email=    user_nameTV.getText().toString();
                String email=    user_emailTV.getText().toString();
                String number=    mobile_numTV.getText().toString();
                String password=    user_passwordTV.getText().toString();
                String confirm=    user_compassTV.getText().toString();
                String fname= user_fnameTV.getText().toString();
                String lname= user_lnameTV.getText().toString();
//                String fullname=    user_Fullname.getText().toString();
                //splitting the given full name to first name and last name.
//
//                Log.d("First name",frstname);
//                Log.d("last name",lastname);

                if (!validateInputs(username,fname,lname,email,number,password,confirm)) return;
                registerUser(username,fname,lname,email,number,password);
            }
        });
    }

    private boolean validateInputs(String username,String fname,String lname,String email,String number,String  password,String confirmPassword){

        if (username.isEmpty()){
            Toast.makeText(this, getString(R.string.username_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (fname.isEmpty()){
            Toast.makeText(this, getString(R.string.first_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (lname.isEmpty()){
            Toast.makeText(this, getString(R.string.last_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()){
            Toast.makeText(this, getString(R.string.email_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!Utils.isValidEmail(email)){
            Toast.makeText(this, getString(R.string.email_not_valid), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (number.isEmpty()){
            Toast.makeText(this, getString(R.string.mobile_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (number.length()!=10){
            Toast.makeText(this, "Phone Number has to be 10 digits!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()){
            Toast.makeText(this, getString(R.string.password_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirmPassword.isEmpty()){
            Toast.makeText(this, getString(R.string.confirm_password_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!confirmPassword.equals(password)){
            Toast.makeText(this, getString(R.string.password_must_be_same), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void registerUser(String username,String firstName,String lastName,String email,String mobileNumber,String password){

        final User user = new User(
                username,
                new Timestamp(new Date()),
                firstName,
                lastName,
                email,
                mobileNumber,
                password
        );

        db.collection(Constants.user)
                .add(user)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, getString(R.string.user_uploaded_successfully), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignupActivity.this,getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });
    }



}