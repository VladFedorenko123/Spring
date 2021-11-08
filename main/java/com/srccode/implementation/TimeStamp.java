package com.srccode.implementation;

import com.srccode.interfaces.Time;

import java.sql.Timestamp;

public class TimeStamp implements Time {
    @Override
    public String getTimestamp() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return time.toString();
    }
}
