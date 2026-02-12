package com.pracconnect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Parameterized_Test.Positive_check;

public class Positive_check_testing {
	//@ParameterizedTest
	//@ValueSource(ints = {1,2,3})
	public void check(int a) {
		Positive_check p = new Positive_check();
		assertTrue(p.check(a));
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,3",
			"5,5,10",
			"5,3,8"})
	public void add(int a, int b, int expectedres) {
		Positive_check p = new Positive_check();
		int actual = p.add(a, b);
		assertEquals(expectedres,actual);
	}
	
}
