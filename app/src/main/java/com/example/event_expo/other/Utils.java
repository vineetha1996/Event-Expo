package com.example.event_expo.other;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.event_expo.model.Event;
import com.example.event_expo.model.OrderedEvent;

public class Utils {

    public static String getFormattedEventDescription(Event event){
        return  "Event Name: " + event.getName() + "\n"
                + "Date: " + event.getDate() + "\n"
                + "Time: " + event.getTime() + "\n"
                + "Price: " + event.getPrice() + "\n"
                + "Description: " + event.getDescription();
    }

    public static String getFormattedOrderedDescription(OrderedEvent orderedEvent){
        Event event = orderedEvent.getEvent();

        String encryptedCardNumber = getEncryptedCardNumber(orderedEvent.getCardNumber());

        return  "Event Name: " + event.getName() + "\n"
                + "Date: " + event.getDate() + "\n"
                + "Time: " + event.getTime() + "\n"
                + "Quantity: " + orderedEvent.getQuantity() + "\n"
                + "Price: " + event.getPrice() + "\n"
                + "Description: " + event.getDescription()  + "\n"
                + "Payment Card Number: " + encryptedCardNumber
                ;
    }

    public static String getEncryptedCardNumber(String cardNumber){
        int cardLength = cardNumber.length();

        StringBuilder encryptedCardNumber = new StringBuilder();
        for (int i = 0; i <cardLength - 2 ; i++) {
            encryptedCardNumber.append("*");
        }
        encryptedCardNumber.append(cardNumber.charAt(cardLength - 2));
        encryptedCardNumber.append(cardNumber.charAt(cardLength - 1));

        return String.valueOf(encryptedCardNumber);
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidExpirationDate(String date){
        return date.matches("\\d\\d\\/\\d\\d");
    }

}
