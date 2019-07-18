package com.example.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RpnCalculatorTest {

	@Test
	public void testAddition() {
		RpnCalculator calculator = new RpnCalculator();
		double result = calculator.solve("12 20 +");
		double expected = 32;
		assertEquals(result, expected, 0.00001);
		
		result = calculator.solve("100 200 +");
		expected = 300;
		assertEquals(result, expected, 0.00001);
	}
	
	@Test
	public void testSubtraction() {
		RpnCalculator calculator = new RpnCalculator();
		double result = calculator.solve("32 20 -");
		double expected = 12;
		assertEquals(result, expected, 0.00001);
		
		result = calculator.solve("100 12 -");
		expected = 88;
		assertEquals(result, expected, 0.00001);
				
	}
	
	@Test
	public void testMultiplication() {
		RpnCalculator calculator = new RpnCalculator();
		double result = calculator.solve("2 20 *");
		double expected = 40;
		assertEquals(result, expected, 0.00001);
		
		result = calculator.solve("100 12 *");
		expected = 1200;
		assertEquals(result, expected, 0.00001);
				
	}
}
