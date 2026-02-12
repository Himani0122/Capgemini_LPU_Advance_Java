package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	public void addTest() {
		int res = Calculator.add(20, 30);
	}
	@Test
	public void reverseTest() {
		String actualres=Calculator.reverseString("data");
		//atad ---> tad
		
		assertEquals("atad",actualres);
	}
	
//	@Test
//	public void reverseTestNull() {
//		String actualres = Calculator.reverseString(null);
//		
//		assertEquals("llun",actualres);
//	}
	
	@Test
	public void factorialTest() {
		int actualres = Calculator.Factorial(4);
		
		assertEquals(24,actualres);
	}
	
	@Test
	public void PalindromeTest() {
		boolean actualres = Calculator.Palindrome("level");
		assertTrue(actualres);
	}
	
	@Test
	public void testAEEx() {
		assertThrows(ArithmeticException.class,()->{Calculator.div(10, 0);});
	}
}

