package com.pracconnect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import Parameterized_Test.EvenOrodd;

public class EvenOrOdd_Test{
	@ParameterizedTest
	@CsvFileSource(resources = "/Book1.csv",numLinesToSkip=1)
	public void evenodd(String input,String expected) {
		EvenOrodd e = new EvenOrodd();
		String actual = e.evenOrOdd(Integer.parseInt(input));
		assertEquals(expected,actual);
	}
}