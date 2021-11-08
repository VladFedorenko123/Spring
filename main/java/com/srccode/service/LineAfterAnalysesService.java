package com.srccode.service;

import com.srccode.dao.LineAfterAnalysesRepository;
import com.srccode.implementation.ConsonantsCalculator;
import com.srccode.implementation.CounterRequest;
import com.srccode.implementation.TimeStamp;
import com.srccode.implementation.VowelsCalculator;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.RequestCounter;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;
import com.srccode.model.LineAfterAnalyses;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineAfterAnalysesService {
    private static final Logger logger = LoggerFactory.getLogger(LineAfterAnalysesService.class);

    Time time = new TimeStamp();
    Vowels vowels = new VowelsCalculator();
    Consonants consonants = new ConsonantsCalculator();
    RequestCounter requestCounter = new CounterRequest();
    LineAfterAnalyses lineAfterAnalyses = new LineAfterAnalyses();

    @Autowired
    private LineAfterAnalysesRepository lineAfterAnalysesRepository;

    public void saveLineAfterAnalyses(String name) {
        if (name.isEmpty()) {
            logger.error("Error: text can not be empty for Analyse!");
        } else {
            if (lineAfterAnalysesRepository.findByStr(name) == null) {
                lineAfterAnalyses.setStr(name);
                lineAfterAnalyses.setVowelsNumber(vowels.getVowels(name));
                lineAfterAnalyses.setConsonantsNumber(consonants.getConsonants(name));
                lineAfterAnalyses.setTimestamp(time.getTimestamp());
                lineAfterAnalyses.setRequestCounter(requestCounter.getRequestCounter("0"));
                lineAfterAnalysesRepository.save(lineAfterAnalyses);
            } else {
                LineAfterAnalyses text = lineAfterAnalysesRepository.findByStr(name);
                text.setRequestCounter(requestCounter.getRequestCounter(lineAfterAnalysesRepository.findByStr(name).getRequestCounter()));
                lineAfterAnalysesRepository.save(text);
            }
        }
    }

    public String readLineAfterAnalyses(String name) {
        JSONObject json = new JSONObject();
        if (name.isEmpty()) {
            logger.error("Error: text can not be empty for Analyse!");
        } else {
            json.put("name", lineAfterAnalysesRepository.findByStr(name).getStr());
            json.put("vowels", lineAfterAnalysesRepository.findByStr(name).getVowelsNumber());
            json.put("consonants", lineAfterAnalysesRepository.findByStr(name).getConsonantsNumber());
            json.put("timestamp", lineAfterAnalysesRepository.findByStr(name).getTimestamp());
            json.put("request counter", lineAfterAnalysesRepository.findByStr(name).getRequestCounter());
        }
        return json.toJSONString();
    }
}
