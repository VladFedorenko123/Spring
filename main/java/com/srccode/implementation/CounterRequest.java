package com.srccode.implementation;

import com.srccode.interfaces.RequestCounter;

public class CounterRequest implements RequestCounter {
    @Override
    public String getRequestCounter(String counter) {
        int counterRequest = 0;
        if (counter == null) {
            counterRequest++;
        } else {
            counterRequest = Integer.parseInt(counter);
            counterRequest++;
        }
        return Integer.toString(counterRequest);
    }
}
