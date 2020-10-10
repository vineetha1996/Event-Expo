package com.example.event_expo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHomeActivity extends AppCompatActivity {
    private Button bookbtn1, bookbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        bookbtn1 = (Button) findViewById(R.id.bookNowBTN1);
        bookbtn2 = (Button) findViewById(R.id.bookNowBTN2);


    }
}