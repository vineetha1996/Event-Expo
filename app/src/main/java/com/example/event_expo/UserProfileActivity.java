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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfileActivity extends AppCompatActivity {
    private EditText userfirstname,userlastname,mobilenumber,useremail;
    private String u_name,u_email,u_phn,u_pass,u_frstname,u_lastname;
    private Button submit;
    private FirebaseFirestore db;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        db = FirebaseFirestore.getInstance();
        sharedPref = SharedPref.getInstance();

        useremail = findViewById(R.id.user_emailTV);
        mobilenumber = findViewById(R.id.mob_numTV);
        userfirstname = findViewById(R.id.first_nameTV);
        userlastname = findViewById(R.id.last_nameTV);
        submit = findViewById(R.id.submit_btn);

        User user = sharedPref.getUser(this);
        userfirstname.setText(user.getFirstName());
        userlastname.setText(user.getLastName());
        mobilenumber.setText(user.getMobileNumber());
        useremail.setText(user.getEmail());

        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstName = userfirstname.getText().toString();
                String lastName = userlastname.getText().toString();
                String emailName = useremail.getText().toString();
                String mobileName = mobilenumber.getText().toString();

                if (!validateInput(firstName,lastName, mobileName, emailName)) return;

                updateUser(firstName,lastName, mobileName, emailName);

            }
        });

    }

    private void updateUser(String firstName, String lastName, String mobileName, String email) {

        db.collection(Constants.user)
                .document(sharedPref.getUserDocumentID(UserProfileActivity.this))
                .update(Constants.firstName,firstName,
                        Constants.lastName,lastName,
                        Constants.email,email,
                        Constants.mobileNumber,mobileName
                        )
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UserProfileActivity.this, "Profile updated!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserProfileActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private boolean validateInput(String firstName,String lastName, String email, String mobile) {

        if (firstName.isEmpty()){
            Toast.makeText(this, getString(R.string.first_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (lastName.isEmpty()){
            Toast.makeText(this, getString(R.string.last_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (mobile.isEmpty()){
            Toast.makeText(this, getString(R.string.mobile_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()){
            Toast.makeText(this, getString(R.string.email_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

}