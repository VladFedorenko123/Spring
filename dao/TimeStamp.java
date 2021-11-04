package com.srccode.dao;

import com.srccode.ui.Time;

import java.sql.Timestamp;

public class TimeStamp implements Time {
    @Override
    public String getTimestamp() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return time.toString();
    }
}
