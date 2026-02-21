package prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesEmployee {
	@Id
	private int empid;
	private String name;
	private String department;
	
	@OneToMany
	private List<Lead> lead;
	
	SalesEmployee(){
		
	}
	public SalesEmployee(int empid, String name, String department, List<Lead> lead) {
		super();
		this.empid = empid;
		this.name = name;
		this.department = department;
		this.lead = lead;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Lead> getLead() {
		return lead;
	}

	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}
	
}
