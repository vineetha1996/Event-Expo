package com.example.event_expo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.event_expo.model.Event;
import com.example.event_expo.model.RequestedEvent;
import com.example.event_expo.model.User;
import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.event_expo.other.Constants.DATE_FORMAT;

public class RequestEventActivity extends AppCompatActivity {

    private EditText etName, etDate, etTime, etPrice, etDescription;
    private FirebaseFirestore db;
    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_event);

        db = FirebaseFirestore.getInstance();

        etName = findViewById(R.id.event_name_TV);
        etDate = findViewById(R.id.event_date_TV);
        etTime = findViewById(R.id.event_time_TV);
        etPrice = findViewById(R.id.event_price_TV);
        etDescription = findViewById(R.id.event_description_TV);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String date = new SimpleDateFormat(DATE_FORMAT, Locale.US).format(calendar.getTime());
                        etDate.setText(date);
                    }

                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestEventActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });

    }

    public void onAddClick(View view) {

        String name = etName.getText().toString();
        String date = etDate.getText().toString();
        String time = etTime.getText().toString();
        String price = etPrice.getText().toString();
        String description = etDescription.getText().toString();

        if (!validateInputs(name, date, time, price, description)) return;
        requestEvent(name, date, time, price, description);
    }

    private boolean validateInputs(String name, String date, String time, String price, String description) {

        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.name_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (date.isEmpty()) {
            Toast.makeText(this, getString(R.string.date_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (time.isEmpty()) {
            Toast.makeText(this, getString(R.string.time_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (price.isEmpty()) {
            Toast.makeText(this, getString(R.string.price_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (description.isEmpty()) {
            Toast.makeText(this, getString(R.string.description_cannot_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void requestEvent(String name, String date, String time, String price, String description) {

        Event event = new Event(
                name,
                new Timestamp(new Date()),
                date,
                time,
                price,
                description
        );

        SharedPref sharedPref = SharedPref.getInstance();
        User user = sharedPref.getUser(RequestEventActivity.this);
        String documentID = sharedPref.getUserDocumentID(RequestEventActivity.this);

        RequestedEvent requestedEvent = new RequestedEvent(
                event,
                user.getFirstName(),
                documentID
        );

        db.collection(Constants.requestedEvent)
                .add(requestedEvent)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RequestEventActivity.this, getString(R.string.event_requested), Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RequestEventActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });


    }


}