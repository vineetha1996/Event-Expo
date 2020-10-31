package com.example.event_expo;

import android.os.Bundle;
import android.content.Context;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserHomeActivity extends AppCompatActivity {// MainActivity extends AppCompatActivity {

    private List<EventDetails> eventList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventDetailsAdaptor mAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new EventDetailsAdaptor(eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(mAdapter);

        populateData();
    }

    private void populateData() {


        EventDetails tv = new EventDetails("Kayaking", "09-20-2020", "14:00", "Sports", "Fun group boating for students.");
        eventList.add(tv);

        EventDetails tv1 = new EventDetails("Strawberry Picking", "08-08-2020", "16:00", "Harvesting", "Enjoy fresh  organic strawberries with your friends and family.");
        eventList.add(tv1);

        EventDetails tv2 = new EventDetails("Pumpkin Carving", "10-25-2020", "15:30", "Art&Crafts", "What screams more than pumpkins for Halloween?");
        eventList.add(tv2);

        EventDetails tv3 = new EventDetails("Cricket Match", "10-17-2020", "17:30", "Sports", "Watch the Challengers VS the Fighters game for the Winter Cup!");
        eventList.add(tv3);

        EventDetails tv4 = new EventDetails("Prom Night", "11-23-2020", "19:30", "Group Events", "Have the time of your lives this year! Don't forget to wear your masks and maintain social distancing :D");
        eventList.add(tv4);

        mAdapter.notifyDataSetChanged();
    }
}

//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class UserHomeActivity extends AppCompatActivity {
//    private Button bookbtn1, bookbtn2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_home);
//
//        bookbtn1 = (Button) findViewById(R.id.bookNowBTN1);
//        bookbtn2 = (Button) findViewById(R.id.bookNowBTN2);
//
//
//        bookbtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i=new Intent(UserHomeActivity.this, IndividualEventDetailsActivity.class);
//                startActivity(i);
//
//            }
//        });
//           bookbtn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent i=new Intent(UserHomeActivity.this, PaymentActivity.class);
//                    startActivity(i);
//
//                }
//        });
//
//
//    }
//}