package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_login_Activity extends AppCompatActivity {
    private Button adminLoginbtn;
    EditText adUser,adPass;
    String adminUser,adminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_);
        adUser = findViewById(R.id.admin_username_ET);
        adPass = findViewById(R.id.admin_password_ET);

        adminUser = "Vineethavinni@96";
        adminPassword = "Vinni@96";

        adminLoginbtn=findViewById(R.id.admin_login_btn);
        adminLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adminUser.equals(adUser.getText().toString())&& adminPassword.equals(adPass.getText().toString())){
                    Intent adminIntent = new Intent(Admin_login_Activity.this,Admin_home_page_Activity.class);
                    startActivity(adminIntent);
                }
            }
        });
    }
}
