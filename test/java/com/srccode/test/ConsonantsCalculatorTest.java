package com.srccode.test;

import com.srccode.implementation.ConsonantsCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsonantsCalculatorTest {
    ConsonantsCalculator objectUnderTest = new ConsonantsCalculator();

    @Test
    void getConsonants() {
        assertEquals("3", objectUnderTest.getConsonants("vlad"));
    }
}