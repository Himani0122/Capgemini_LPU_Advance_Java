package Assignment;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Aadhar {
	@Id
	int aadharId;
	int number;
	String address;
	String issueDate;
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "AadharCard [aadharId=" + aadharId + ", number=" + number + ", address=" + address + ", issueDate="
				+ issueDate + "]";
	}
	

}
