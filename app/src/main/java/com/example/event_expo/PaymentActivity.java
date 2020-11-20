package com.example.event_expo;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.model.Event;
import com.example.event_expo.model.OrderedEvent;
import com.example.event_expo.other.Constants;
import com.example.event_expo.other.SharedPref;
import com.example.event_expo.other.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PaymentActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private EditText etCardName, etCardNumber, etExpirationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        final Event event = intent.getParcelableExtra(Constants.event);
        final String quantity = String.valueOf(intent.getIntExtra(Constants.quantity,0));

        Button makePaymentBTN = (Button) findViewById(R.id.makePaymentBTN);

        etCardName = findViewById(R.id.cardNameET);
        etCardNumber = findViewById(R.id.cardNumberET);
        etExpirationDate = findViewById(R.id.dateET);

        makePaymentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameOnCard = etCardName.getText().toString();
                String cardNumber = etCardNumber.getText().toString();
                String cardExpirationDate = etExpirationDate.getText().toString();

                if (!validateInputs(nameOnCard,cardNumber,cardExpirationDate)) return;

                OrderedEvent orderedEvent = new OrderedEvent(
                        event,
                        quantity,
                        nameOnCard,
                        cardNumber,
                        cardExpirationDate
                );
                String userDocumentID = SharedPref.getInstance().getUserDocumentID(PaymentActivity.this);

                db.collection(Constants.user).document(userDocumentID)
                        .collection(Constants.orderedEvent)
                        .add(orderedEvent)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(PaymentActivity.this, "Event Booked!", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(PaymentActivity.this,UserMaintenanceActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(PaymentActivity.this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }

    private boolean validateInputs(String nameOnCard, String cardNumber, String cardExpirationDate){

        if (nameOnCard.isEmpty()) {
            Toast.makeText(this, "Name On Card cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cardNumber.isEmpty()) {
            Toast.makeText(this, "Card number cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cardExpirationDate.isEmpty()) {
            Toast.makeText(this, "Card expiration date cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Utils.isValidExpirationDate(cardExpirationDate)) {
            Toast.makeText(this, "Expiration Date must be in XX/XX format", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void postOrder(Event event,String cardName, String cardNumber, String expirationDate){

//        db.collection()

    }

}
