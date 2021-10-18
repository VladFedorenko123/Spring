package com.srccode.test;

import com.srccode.clas.ConsonantsCalculator;
import com.srccode.clas.CounterRequest;
import com.srccode.clas.TimeStamp;
import com.srccode.clas.VowelsCalculator;
import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.interfaces.*;
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
    Time timestamp = new TimeStamp();
    Counter counter = new CounterRequest();
    @Autowired
    private MongoPutTextRepository mongoPutTextRepository;

    @Test
    public void test() {
        LineAfterAnalysesDTO lineAfterAnalysesDTO = new LineAfterAnalysesDTO();
        lineAfterAnalysesDTO.setStr("Petro");
        lineAfterAnalysesDTO.setVowelsNumber(vowels.getVowels("Petro"));
        lineAfterAnalysesDTO.setConsonantsNumber(consonants.getConsonants("Petro"));
        mongoPutTextRepository.save(lineAfterAnalysesDTO);
        assertEquals("Petro", mongoPutTextRepository.findByStr("Petro").getStr());
        assertEquals("2", mongoPutTextRepository.findByStr("Petro").getVowelsNumber());
        assertEquals("3", mongoPutTextRepository.findByStr("Petro").getConsonantsNumber());
        mongoPutTextRepository.delete(lineAfterAnalysesDTO);

    }
}
