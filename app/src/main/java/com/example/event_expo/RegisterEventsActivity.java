package com.example.event_expo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.adapter.EventAdapter;
import com.example.event_expo.listener.OnEventClickListener;
import com.example.event_expo.model.Event;
import com.example.event_expo.model.RequestedEvent;
import com.example.event_expo.other.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RegisterEventsActivity extends AppCompatActivity implements OnEventClickListener {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_events);

        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.rvRequestEvent);
        fetchEvents();
    }

    private void fetchEvents() {
        db.collection(Constants.requestedEvent)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            ArrayList<Event> events = new ArrayList<>();
                            for (QueryDocumentSnapshot item : task.getResult()){
                                events.add(item.toObject(RequestedEvent.class).getEvent());
                            }
                            EventAdapter adapter = new EventAdapter(events,RegisterEventsActivity.this);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(RegisterEventsActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public void onEventClick(Event event,int position) {
        // DO NOTHING
    }
}