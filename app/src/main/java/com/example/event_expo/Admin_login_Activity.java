package com.example.event_expo;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Admin_login_Activity extends AppCompatActivity {

    private Button adminLoginbtn;
    private EditText adUser, adPass;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_);

        db = FirebaseFirestore.getInstance();

        adUser = findViewById(R.id.admin_username_ET);
        adPass = findViewById(R.id.admin_password_ET);

        adminLoginbtn = findViewById(R.id.admin_login_btn);
        adminLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = adUser.getText().toString();
                String password = adPass.getText().toString();

                if (!validateInput(username,password)) return;

                loginAdmin(username,password);

            }
        });
    }

    private boolean validateInput(String username, String password) {

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

    private void loginAdmin(String username, String password) {
        db.collection(Constants.admin)
                .whereEqualTo(Constants.username, username)
                .whereEqualTo(Constants.password, password)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int size = task.getResult().getDocuments().size();
                            if (size==1){
                                SharedPref sharedPref= SharedPref.getInstance();
                                sharedPref.setLoginType(Admin_login_Activity.this,Constants.admin);
                                Intent intent = new Intent(Admin_login_Activity.this,Admin_home_page_Activity.class);
                                startActivity(intent);
                                finish();
                            }else if (size==0){
                                Toast.makeText(Admin_login_Activity.this, getString(R.string.wrong_credentials), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Admin_login_Activity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

}
