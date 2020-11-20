package com.example.event_expo;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.other.Constants;
import com.example.event_expo.other.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etUsername,etPassword, etConfirmPassword;
    private Button btnUpdate;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = FirebaseFirestore.getInstance();

        etUsername = findViewById(R.id.user_nameTV_Forgot_Pass);
        etPassword = findViewById(R.id.user_passwordTV_Forgot_Pass);
        etConfirmPassword = findViewById(R.id.user_compassTV_Forgot_Pass);
        btnUpdate = findViewById(R.id.update_btn_forgot_password);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (!validateInputs(username,password,confirmPassword)) return;

                fetchUsername(username,password);

            }
        });


//        etPassword = findViewById(R.id.user_passwordTV);
//        etConfirmPassword = findViewById(R.id.user_compassTV);

//        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String username = etUsername.getText().toString();
//                String email = etEmail.getText().toString();
//                String mobile = etMobile.getText().toString();
//                String password = etPassword.getText().toString();
//                String confirmPassword = etConfirmPassword.getText().toString();
//
//                if (!validateInput(username,email,mobile,password,confirmPassword))return;
//
//
//
//            }
//        });

    }

    private void fetchUsername(String username, final String password) {

        db.collection(Constants.user)
                .whereEqualTo(Constants.username,username)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            List<DocumentSnapshot> documentSnapshot =  task.getResult().getDocuments();
                            if (documentSnapshot.size()==1){
                                userPassword(documentSnapshot.get(0).getId(),password);
                            }else if (documentSnapshot.size()==0){
                                Toast.makeText(ForgotPasswordActivity.this, "No User Exists", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(ForgotPasswordActivity.this, "Multiple User exists", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(ForgotPasswordActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void userPassword(String userDocumentID,String password){

        db.collection(Constants.user).document(userDocumentID)
                .update(
                        Constants.password,password
                ).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ForgotPasswordActivity.this, "User password changed", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ForgotPasswordActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validateInputs(String username, String password, String confirmPassword) {

        if (username.isEmpty()){
            Toast.makeText(this, getString(R.string.username_cannot_empty), Toast.LENGTH_SHORT).show();
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


}