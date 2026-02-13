package Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student_Data")
public class Student {
	@Id
	int stuId;
	String name;
	String email;
	String branch;
	
	@OneToOne
	Aadhar aadhar;
	@OneToOne
	Hostel hostel;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Aadhar getAadharCard() {
		return aadhar;
	}
	public void setAadharCard(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	public Hostel getHostel() {
		return hostel;
	}
	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", email=" + email + ", branch=" + branch
				+ ", aadharCard=" + aadhar + ", hostel=" + hostel + "]";
	}
	
	
	
	
	
	

}