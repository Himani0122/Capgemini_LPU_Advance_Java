package prac;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Order {
	private int Orderid;
	private String orderDate;
	private double totalAmount;
	
	@ManyToOne
	private Customer customer;
	@ManyToMany
	private List<Product> list;
	
	Order(){
		
	}
	public Order(int orderid, String orderDate, double totalAmount, Customer customer, List<Product> list) {
		super();
		Orderid = orderid;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.list = list;
	}
	public int getOrderid() {
		return Orderid;
	}
	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	
	
	
}
