package com.example.event_expo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.event_expo.R;
import com.example.event_expo.model.OrderedEvent;

import java.util.List;

import static com.example.event_expo.other.Utils.getFormattedOrderedDescription;

public class OrderedEventAdapter extends RecyclerView.Adapter<OrderedEventAdapter.StudentViewHolder> {

    private final List<OrderedEvent> eventList;

    public OrderedEventAdapter(List<OrderedEvent> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_event, parent, false);
        return new OrderedEventAdapter.StudentViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        OrderedEvent orderedEvent = eventList.get(position);

        holder.textView.setText(
                getFormattedOrderedDescription(orderedEvent)
        );
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
