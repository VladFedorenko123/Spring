package com.srccode.service;

import com.srccode.dao.ConsonantsCalculator;
import com.srccode.dao.CounterRequest;
import com.srccode.dao.TimeStamp;
import com.srccode.dao.VowelsCalculator;
import com.srccode.model.LineAfterAnalyses;
import com.srccode.repository.LineAfterAnalysesRepository;
import com.srccode.ui.Consonants;
import com.srccode.ui.Counter;
import com.srccode.ui.Time;
import com.srccode.ui.Vowels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineAfterAnalysesService {

    Time timestamp = new TimeStamp();
    Vowels vowels = new VowelsCalculator();
    Counter counter = new CounterRequest();
    Consonants consonants = new ConsonantsCalculator();
    LineAfterAnalyses lineAfterAnalyses = new LineAfterAnalyses();

    @Autowired
    private LineAfterAnalysesRepository lineAfterAnalysesRepository;

    public void saveAnalyses(String name) {
        lineAfterAnalyses.setStr(name);
        lineAfterAnalyses.setVowelsNumber(vowels.getVowels(name));
        lineAfterAnalyses.setConsonantsNumber(consonants.getConsonants(name));
        lineAfterAnalyses.setTimestamp(timestamp.getTimestamp());
        lineAfterAnalyses.setRequestCounter(counter.getRequestCounter("0"));
        lineAfterAnalysesRepository.save(lineAfterAnalyses);
    }

    public void findAnalyses(String name) {
        LineAfterAnalyses text = lineAfterAnalysesRepository.findByStr(name);
        text.setRequestCounter(counter.getRequestCounter(lineAfterAnalysesRepository.findByStr(name).getRequestCounter()));
        lineAfterAnalysesRepository.save(text);
    }

    public String findName(String name) {
        return lineAfterAnalysesRepository.findByStr(name).getStr();
    }

    public String findVowels(String name) {
        return lineAfterAnalysesRepository.findByStr(name).getVowelsNumber();
    }

    public String findConsonants(String name) {
        return lineAfterAnalysesRepository.findByStr(name).getConsonantsNumber();
    }

    public String findTimestamp(String name) {
        return lineAfterAnalysesRepository.findByStr(name).getTimestamp();
    }

    public String findRequestCounter(String name) {
        return lineAfterAnalysesRepository.findByStr(name).getRequestCounter();
    }
}
