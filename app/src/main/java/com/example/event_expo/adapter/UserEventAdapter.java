package com.example.event_expo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.R;
import com.example.event_expo.listener.OnEventClickListener;
import com.example.event_expo.model.Event;

import java.util.List;

public class UserEventAdapter extends RecyclerView.Adapter<UserEventAdapter.StudentViewHolder> {

    private final List<Event> eventList;
    private OnEventClickListener onEventClickListener;

    public UserEventAdapter(List<Event> eventList,OnEventClickListener onEventClickListener) {
        this.eventList = eventList;
        this.onEventClickListener = onEventClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_event, parent, false);
        return new UserEventAdapter.StudentViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, int position) {
        final Event event = eventList.get(position);

        holder.textView.setText(
                "Event Name: " + event.getName() + "\n"
                        + "Date: " + event.getDate() + "\n"
                        + "Time: " + event.getTime() + "\n"
                        + "Price: " + event.getPrice() + "\n"
                        + "Description: " + event.getDescription()
        );

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEventClickListener.onEventClick(event,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public StudentViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.event2TV);
        }
    }

}
