package com.srccode.dao;

import com.srccode.ui.Counter;

public class CounterRequest implements Counter {
    @Override
    public String getRequestCounter(String k) {
        int counter = 0;

        if (k == null) {
            counter++;
        } else {
            counter = Integer.parseInt(k);
            counter++;
        }
        return Integer.toString(counter);
    }
}
