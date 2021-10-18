package com.srccode.test;

import com.srccode.clas.ConsonantsCalculator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsonantsCalculatorTest {
    ConsonantsCalculator objectUnderTest = new ConsonantsCalculator();

    @Test
    void testGetConsonants() {
        assertEquals("3", objectUnderTest.getConsonants("vlad"));
        assertEquals("2", objectUnderTest.getConsonants("vova"));
        assertEquals("2", objectUnderTest.getConsonants("vasia"));
    }

}
