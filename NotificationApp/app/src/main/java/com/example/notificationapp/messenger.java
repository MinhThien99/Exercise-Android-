package com.example.notificationapp;

public class messenger {
    private CharSequence text ;
    private long timestamp;
    private CharSequence sender;

    public messenger() {
    }


    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public CharSequence getSender() {
        return sender;
    }

    public void setSender(CharSequence sender) {
        this.sender = sender;
    }

    public messenger(CharSequence text, CharSequence sender) {
        this.text = text;
        this.sender = sender;
        this.timestamp = System.currentTimeMillis();

    }
}
