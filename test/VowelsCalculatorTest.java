package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import com.srccode.clas.VowelsCalculator;


class VowelsCalculatorTest {
	VowelsCalculator objectUnderTest = new VowelsCalculator();

	@Test
	void test() {
		assertEquals("1", objectUnderTest.getVowels("vlad"));
		assertEquals("2", objectUnderTest.getVowels("vova"));
		assertEquals("3", objectUnderTest.getVowels("vasia"));
	}

}
