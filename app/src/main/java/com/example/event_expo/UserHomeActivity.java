package com.example.event_expo;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.adapter.EventAdapter;
import com.example.event_expo.adapter.UserEventAdapter;
import com.example.event_expo.listener.OnEventClickListener;
import com.example.event_expo.model.Event;
import com.example.event_expo.other.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserHomeActivity extends AppCompatActivity implements OnEventClickListener {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        db = FirebaseFirestore.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fetchEvents();
    }

    private void fetchEvents() {
        db.collection(Constants.event)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            ArrayList<Event> events = new ArrayList<>();
                            for (QueryDocumentSnapshot item : task.getResult()){
                                events.add(item.toObject(Event.class));
                            }
                            UserEventAdapter adapter = new UserEventAdapter(events,UserHomeActivity.this);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(UserHomeActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public void onEventClick(Event event,int position) {
        Intent intent = new Intent(this,IndividualEventDetailsActivity.class);
        intent.putExtra(Constants.event,event);
        startActivity(intent);
    }
}