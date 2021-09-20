package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.srccode.clas.ConsonantsCalculator;

class ConsonantsCalculatorTest {
	ConsonantsCalculator objectUnderTest = new ConsonantsCalculator();

	@Test
	void testGetConsonants() {
		assertEquals("3", objectUnderTest.getConsonants("vlad"));
		assertEquals("2", objectUnderTest.getConsonants("vova"));
		assertEquals("2", objectUnderTest.getConsonants("vasia"));
	}

}
