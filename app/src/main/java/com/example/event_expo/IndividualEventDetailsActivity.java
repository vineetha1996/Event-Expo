package com.example.event_expo;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_expo.model.Event;
import com.example.event_expo.other.Constants;

import static com.example.event_expo.other.Constants.MAX_QUANTITY;
import static com.example.event_expo.other.Constants.MIN_QUANTITY;
import static com.example.event_expo.other.Utils.getFormattedEventDescription;

public class IndividualEventDetailsActivity extends AppCompatActivity {

    private int quantity = 1;
    private TextView tvQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_event_details);

        final Event event = getIntent().getParcelableExtra(Constants.event);
        TextView tvDescription = findViewById(R.id.eventDisplayTV);
        ImageView ivPlus = findViewById(R.id.ivIncreaseQuantity);
        ImageView ivMinus = findViewById(R.id.ivDecreaseQuantity);
        tvQuantity = findViewById(R.id.quantityDisplayTV);
        tvDescription.setText(getFormattedEventDescription(event));

        Button addToCartBTN = (Button) findViewById(R.id.addToCartBTN);

        addToCartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(IndividualEventDetailsActivity.this, PaymentActivity.class);
                i.putExtra(Constants.event, event);
                i.putExtra(Constants.quantity, quantity);
                startActivity(i);

            }
        });

        ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreaseQuantity();
            }
        });

        ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseQuantity();
            }
        });

    }

    private void decreaseQuantity() {

        if (quantity >= MIN_QUANTITY + 1) {
            quantity--;
            tvQuantity.setText("Quantity: " + quantity);
        } else {
            Toast.makeText(this, "Quantity cannot be less than " + MIN_QUANTITY, Toast.LENGTH_SHORT).show();
        }

    }

    private void increaseQuantity() {

        if (quantity <= MAX_QUANTITY - 1) {
            quantity++;
            tvQuantity.setText("Quantity: " + quantity);
        } else {
            Toast.makeText(this, "Quantity cannot be more than " + MAX_QUANTITY, Toast.LENGTH_SHORT).show();
        }


    }

}
