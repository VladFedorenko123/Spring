package com.srccode.clas;

import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.interfaces.*;

public class JsonBuilder implements Json {
    Vowels vowels = new VowelsCalculator();
    Consonants consonants = new ConsonantsCalculator();
    Time timestamp = new TimeStamp();
    Counter counter = new CounterRequest();

    @Override
    public String getJson(String inputType, String text, String counter) {
        LineAfterAnalysesDTO dto = new LineAfterAnalysesDTO(vowels.getVowels(text), consonants.getConsonants(text),
                timestamp.getTimestamp());
        String json = "[\n {\n " + inputType + ": \n" + " Text: \"" + text + "\"\n Vowels: " + dto.getVowelsNumber()
                + "\n Consonants: " + dto.getConsonantsNumber() + "\n Timestamp: " + dto.getTimestamp()
                + "\n RequestCounter: " + counter + " }\n]\n";
        return json;
    }
}
