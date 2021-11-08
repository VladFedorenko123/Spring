package com.srccode.test;

import com.srccode.implementation.VowelsCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VowelsCalculatorTest {
    VowelsCalculator objectUnderTest = new VowelsCalculator();
    @Test
    void getVowels() {
        assertEquals("1", objectUnderTest.getVowels("vlad"));
    }
}