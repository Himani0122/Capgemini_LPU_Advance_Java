package EcommerceOrderModule;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
	private int pa_id;
	private String mode;
	private double amount;
	
	@ManyToOne
	PurchaseOrder p;
	
	public PurchaseOrder getP() {
		return p;
	}
	public void setP(PurchaseOrder p) {
		this.p = p;
	}

	public int getPa_id() {
		return pa_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
