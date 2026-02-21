package prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SupportTicket {
	@Id
	private int sid;
	private String issue;
	
	@OneToOne
	private Order order;

	SupportTicket(){
		
	}

	public SupportTicket(int sid, String issue, Order order) {
		super();
		this.sid = sid;
		this.issue = issue;
		this.order = order;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
