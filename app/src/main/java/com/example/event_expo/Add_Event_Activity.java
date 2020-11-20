package com.example.event_expo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.event_expo.model.Event;
import com.example.event_expo.other.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.event_expo.other.Constants.DATE_FORMAT;
import static com.example.event_expo.other.Constants.eventType;

public class Add_Event_Activity extends AppCompatActivity {

    private EditText etName, etDate, etTime, etPrice, etDescription;
    private FirebaseFirestore db;
    private final Calendar calendar = Calendar.getInstance();
    private Event eventData;
    private String eventDocumentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event_);

        db = FirebaseFirestore.getInstance();

        etName = findViewById(R.id.event_name_TV);
        etDate = findViewById(R.id.event_date_TV);
        etTime = findViewById(R.id.event_time_TV);
        etPrice = findViewById(R.id.event_price_TV);
        etDescription = findViewById(R.id.event_description_TV);

        String eventType = getIntent().getStringExtra(Constants.eventType);
        eventData = getIntent().getParcelableExtra(Constants.event);
        eventDocumentID = getIntent().getStringExtra(Constants.EVENT_DOCUMENT_ID);

        if (eventType!=null){
            etName.setText(eventType);
        }else if (eventData!=null){
            displayDataToEdiText();
        }

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

                DatePickerDialog datePickerDialog = new DatePickerDialog(Add_Event_Activity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });
    }
    
    private void displayDataToEdiText(){
        etName.setText(eventData.getName());
        etDate.setText(eventData.getDate());
        etTime.setText(eventData.getTime());
        etPrice.setText(eventData.getPrice());
        etDescription.setText(eventData.getDescription());
    }

    public void onAddClick(View view) {

        String name = etName.getText().toString();
        String date = etDate.getText().toString();
        String time = etTime.getText().toString();
        String price = etPrice.getText().toString();
        String description = etDescription.getText().toString();

        if (!validateInputs(name, date, time, price, description)) return;
        
        if (eventData!=null){
            updateEvent(name, date, time, price, description);
        }else{
            addEvent(name, date, time, price, description);
        }
    }

    private void updateEvent(String name, String date, String time, String price, String description) {

        db.collection(Constants.event).document(eventDocumentID)
                .update(
                        Constants.name,name,
                        Constants.date,date,
                        Constants.price,price,
                        Constants.description,description,
                        Constants.time,time
                ).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        setResult(Activity.RESULT_OK);finish();
                        Toast.makeText(Add_Event_Activity.this, "Profile updated!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Add_Event_Activity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });

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

    private void addEvent(String name, String date, String time, String price, String description) {

        Event event = new Event(
                name,
                new Timestamp(new Date()),
                date,
                time,
                price,
                description
        );

        db.collection(Constants.event)
                .add(event)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Add_Event_Activity.this, getString(R.string.event_uploaded), Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Add_Event_Activity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
            }
        });


    }

}