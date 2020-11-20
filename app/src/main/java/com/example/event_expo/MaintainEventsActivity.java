package com.example.event_expo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.adapter.EventAdapter;
import com.example.event_expo.listener.OnEventClickListener;
import com.example.event_expo.model.Event;
import com.example.event_expo.other.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MaintainEventsActivity extends AppCompatActivity implements OnEventClickListener {

    private int LAUNCH_EDIT_EVENT = 101;

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private final ArrayList<QueryDocumentSnapshot> snapshotArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_events);

        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recyclerView);
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
                                snapshotArrayList.add(item);
                                events.add(item.toObject(Event.class));
                            }
                            EventAdapter adapter = new EventAdapter(events,MaintainEventsActivity.this);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(MaintainEventsActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public void onEventClick(Event event, int position) {
        Intent intent = new Intent(MaintainEventsActivity.this,Add_Event_Activity.class);
        intent.putExtra(Constants.event,event);
        intent.putExtra(Constants.EVENT_DOCUMENT_ID,snapshotArrayList.get(position).getId());
        startActivityForResult(intent,LAUNCH_EDIT_EVENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_EDIT_EVENT && resultCode == Activity.RESULT_OK){
            fetchEvents();
        }
    }
}