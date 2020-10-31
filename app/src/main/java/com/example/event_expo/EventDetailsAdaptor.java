package com.example.event_expo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventDetailsAdaptor extends RecyclerView.Adapter<EventDetailsAdaptor.EventDetailsViewHolder> {

    private List<EventDetails> eventDetailsList;


    public class EventDetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView event_name, date, time, desc, category;
        public  RelativeLayout relativeLayout;

        public EventDetailsViewHolder(View view) {
            super(view);

            event_name = (TextView) view.findViewById(R.id.event_name_TV);
            date = (TextView) view.findViewById(R.id.event_date_TV);
            time = (TextView) view.findViewById(R.id.event_time_TV);
            category = (TextView) view.findViewById(R.id.event_cat_TV);
            desc = (TextView) view.findViewById(R.id.event_description_TV);
        }
    }


    public EventDetailsAdaptor(List<EventDetails> eventDetailsList) {

        this.eventDetailsList = eventDetailsList;

    }

    @Override
    public EventDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user_home_list, parent, false);

        return new EventDetailsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventDetailsViewHolder holder, int position) {
        EventDetails tv = eventDetailsList.get(position);
        holder.event_name.setText(tv.getEvent_name());
        holder.date.setText(tv.getDate());
        holder.time.setText(tv.getTime());
        holder.category.setText(tv.getCategory());
        holder.desc.setText(tv.getDesc());
    }

    @Override
    public int getItemCount() {
        return eventDetailsList.size();
    }
}