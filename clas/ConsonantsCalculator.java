package com.srccode.clas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.srccode.interfaces.Consonants;

public class ConsonantsCalculator implements Consonants {
    private static final List<Character> CONSONANTS = new ArrayList<>(Arrays.asList('b', 'c', 'd', 'f', 'q', 'j', 'k',
            'l', 'm', 'n', 'p', 'g', 's', 't', 'v', 'x', 'z', 'h', 'r', 'w'));

    @Override
    public String getConsonants(String text) {
        text = text.toLowerCase();
        int consonantsCounter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (CONSONANTS.contains(text.charAt(i))) {
                consonantsCounter++;
            }
        }
        return Integer.toString(consonantsCounter);
    }
}
