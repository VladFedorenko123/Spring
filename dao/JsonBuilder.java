package com.srccode.dao;

import com.srccode.ui.Json;

public class JsonBuilder implements Json {
    @Override
    public String getJson(String str, String vowels, String consonants, String timestamp, String requestCounter) {

        String json = "[\n {\n Text: \"" + str + "\"\n Vowels: " + vowels
                + "\n Consonants: " + consonants + "\n Timestamp: " + timestamp
                + "\n RequestCounter: " + requestCounter + "\n }\n]\n";
        return json;
    }
}
