package com.example.event_expo;

/**
 Created by udara abeythilake
 19/05/2019
 **/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserHomeActivity extends AppCompatActivity {// MainActivity extends AppCompatActivity {

    private List<EventDetails> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventDetailsAdaptor mAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_home);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//        mAdapter = new EventDetailsAdaptor(movieList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//
//        recyclerView.setAdapter(mAdapter);
//
//        populateData();
    }

//    private void populateData() {

//        String[] tvseries = new String[]{
//                "https://wallpapersite.com/images/pages/pic_w/14693.jpg",
//                "https://wallpapersite.com/images/pages/pic_w/9678.jpg",
//                "https://stmed.net/sites/default/files/the-blacklist-wallpapers-31695-8813388.jpg",
//                "https://stmed.net/sites/default/files/styles/1280×720/public/lucifer-wallpapers-31613-6873183.jpg?itok=74jI2BiU",
//                "https://stmed.net/sites/default/files/styles/1280×720/public/the-big-bang-theory-wallpapers-31694-2815088.jpg?itok=K_MjM_rv",
//                "https://wallpapersite.com/images/pages/pic_w/1658.jpg",
//                "https://i.ytimg.com/vi/IsMRioOpZrY/maxresdefault.jpg",
//                "https://stmed.net/sites/default/files/styles/1280×720/public/the-100-wallpapers-31691-3965773.jpg?itok=GIFpBqsA",
//                "https://wallpapercave.com/wp/wp1865530.jpg",
//                "https://wallpapersite.com/images/pages/pic_w/17210.jpg",
//
//        };

//        EventDetails tv = new EventDetails("Arrow","7.5","2012");
//        movieList.add(tv);

//        tv = new EventDetails("SuperGirl","6.7","2015");
//        movieList.add(tv);
//
//        tv = new EventDetails("The BlackList","7.7","2013");
//        movieList.add(tv);
//
//        tv = new EventDetails("Lucifer","9.2","2015");
//        movieList.add(tv);
//
//        tv = new EventDetails("The Big Bang Theory","6.4","2007");
//        movieList.add(tv);
//
//        tv = new EventDetails("Flash","6.9","2014");
//        movieList.add(tv);
//
//        tv = new EventDetails("Game of Thrones","9.4","2011");
//        movieList.add(tv);
//
//        tv = new EventDetails("The 100","7.4","2014");
//        movieList.add(tv);
//
//        tv = new EventDetails("Agent of Sheild","8.2","2013");
//        movieList.add(tv);
//
//        tv = new EventDetails("Daredevil","6.9","2015");
//        movieList.add(tv);
//
//        mAdapter.notifyDataSetChanged();
//    }

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