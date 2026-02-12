package Parameterized_Test;

public class Program {
	public boolean isPalindrome(String str) {
		StringBuilder s = new StringBuilder(str);
		return (str.equals(s.reverse().toString())?true:false);
	}
}
