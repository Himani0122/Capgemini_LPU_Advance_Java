package Mockito_practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Dao {
	@Id
	private int id;
	private String name;
	private double balance;
	
	public User_Dao() {
		
	}
	public User_Dao(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User_Dao [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
