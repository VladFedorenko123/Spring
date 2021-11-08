package com.srccode.test;

import com.srccode.dao.LineAfterAnalysesRepository;
import com.srccode.implementation.ConsonantsCalculator;
import com.srccode.implementation.VowelsCalculator;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Vowels;
import com.srccode.model.LineAfterAnalyses;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {
    Vowels vowels = new VowelsCalculator();
    Consonants consonants = new ConsonantsCalculator();
    LineAfterAnalyses lineAfterAnalyses = new LineAfterAnalyses();

    @Autowired
    private LineAfterAnalysesRepository lineAfterAnalysesRepository;

    @Test
    public void MongoDbTest() {
        lineAfterAnalyses.setStr("Petro");
        lineAfterAnalyses.setVowelsNumber(vowels.getVowels("Petro"));
        lineAfterAnalyses.setConsonantsNumber(consonants.getConsonants("Petro"));
        lineAfterAnalysesRepository.save(lineAfterAnalyses);
        assertEquals("Petro", lineAfterAnalysesRepository.findByStr("Petro").getStr());
        assertEquals("2", lineAfterAnalysesRepository.findByStr("Petro").getVowelsNumber());
        assertEquals("3", lineAfterAnalysesRepository.findByStr("Petro").getConsonantsNumber());
        lineAfterAnalysesRepository.delete(lineAfterAnalyses);
    }
}
