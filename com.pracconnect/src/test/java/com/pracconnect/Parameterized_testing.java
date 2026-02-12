package com.pracconnect;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Parameterized_Test.Program;


public class Parameterized_testing {
	@ParameterizedTest
	@ValueSource(strings = {"tenet","radar","aba"})
	public void isPlalindromeTest(String str) {
		Program p = new Program();
		assertTrue(p.isPalindrome(str));
	}
}
