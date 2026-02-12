package com.prac;

public class Employee {
	private Integer id;
	private String name;
	private Integer age;
	private String dept;
	
	public Employee(Integer id, String name, Integer age, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public boolean isValidAge() {
		if(age>17) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValidName() {
		for(int i=0;i<name.length();i++) {
			if(!(Character.isLetter(name.charAt(i)))) {
				return false;
			}else if(name.charAt(i)==' ') {
				return true;
			}
		}
		return true;
	}
	
	
}
