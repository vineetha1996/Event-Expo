package com.example.event_expo;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.adapter.EventAdapter;
import com.example.event_expo.adapter.OrderedEventAdapter;
import com.example.event_expo.model.Event;
import com.example.event_expo.model.OrderedEvent;
import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recyclerView2);
        fetchOrderedEvents();
    }

    private void fetchOrderedEvents() {

        SharedPref sharedPref = SharedPref.getInstance();
        String userDocumentID = sharedPref.getUserDocumentID(this);

        db.collection(Constants.user).document(userDocumentID)
                .collection(Constants.orderedEvent)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            ArrayList<OrderedEvent> events = new ArrayList<>();
                            for (QueryDocumentSnapshot item : task.getResult()){
                                events.add(item.toObject(OrderedEvent.class));
                            }
                            OrderedEventAdapter adapter = new OrderedEventAdapter(events);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(OrderHistoryActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}