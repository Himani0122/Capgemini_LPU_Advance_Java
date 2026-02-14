package EcommerceOrderModule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	@Id
	private int pid;
	private long phone;
	private String address;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
