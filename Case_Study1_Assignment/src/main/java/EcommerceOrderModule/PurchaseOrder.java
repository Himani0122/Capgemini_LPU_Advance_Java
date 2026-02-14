package EcommerceOrderModule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	private int poid;
	private String orderDate;
	private double totalamount;
	
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getAmount() {
		return totalamount;
	}
	public void setAmount(double totalamount) {
		this.totalamount = totalamount;
	}
	
	
}
