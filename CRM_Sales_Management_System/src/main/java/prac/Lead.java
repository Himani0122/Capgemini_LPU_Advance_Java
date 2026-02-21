package prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lead {
	@Id
	private int leadid;
	private String name;
	private String source;
	private String contactInfo;
	
	@ManyToOne
	private SalesEmployee employee;

	public Lead(int leadid, String name, String source, String contactInfo, SalesEmployee employee) {
		super();
		this.leadid = leadid;
		this.name = name;
		this.source = source;
		this.contactInfo = contactInfo;
		this.employee = employee;
	}
	Lead(){
		
	}

	public int getLeadid() {
		return leadid;
	}

	public void setLeadid(int leadid) {
		this.leadid = leadid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public SalesEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}
	
	
	
	
}
