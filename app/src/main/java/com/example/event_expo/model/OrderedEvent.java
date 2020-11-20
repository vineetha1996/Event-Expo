package com.example.event_expo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderedEvent implements Parcelable {

    private Event event;
    private String quantity;
    private String nameOnCard;
    private String cardNumber;
    private String cardExpirationDate;

    public OrderedEvent(Event event, String quantity, String nameOnCard, String cardNumber, String cardExpirationDate) {
        this.event = event;
        this.quantity = quantity;
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
    }

    public OrderedEvent(){}

    protected OrderedEvent(Parcel in) {
        event = in.readParcelable(Event.class.getClassLoader());
        quantity = in.readString();
        nameOnCard = in.readString();
        cardNumber = in.readString();
        cardExpirationDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(event, flags);
        dest.writeString(quantity);
        dest.writeString(nameOnCard);
        dest.writeString(cardNumber);
        dest.writeString(cardExpirationDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OrderedEvent> CREATOR = new Creator<OrderedEvent>() {
        @Override
        public OrderedEvent createFromParcel(Parcel in) {
            return new OrderedEvent(in);
        }

        @Override
        public OrderedEvent[] newArray(int size) {
            return new OrderedEvent[size];
        }
    };

    public Event getEvent() {
        return event;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }
}
