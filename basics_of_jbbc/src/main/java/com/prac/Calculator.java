package com.prac;

public class Calculator {
	public static int add(int a,int b) {
		return (a+b);
	}
	public static String reverseString(String a){
		String rev="";
//		if(a.equals(null)) {
//			throw new NullPointerException();
//		}
		try {
			a.equals(null);
		}catch(Exception e) {
			e.getMessage();
		}
		for(int i=a.length()-1;i>=0;i--) {
			rev+=a.charAt(i);
		}
		return rev;
	}
	public static int Factorial(int a) {
		if(a==0) {
			return 1;
		}
		return a*Factorial(a-1);
	}
	
	public static boolean Palindrome(String a) {
		String rev = "";
		for(int i=a.length()-1;i>=0;i--) {
			rev+=a.charAt(i);
		}
		if(a.equals(rev)) {
			return true;
		}
		return false;
	}
	public static int div(int a,int b) {
		return a/b;
	}
	
}
