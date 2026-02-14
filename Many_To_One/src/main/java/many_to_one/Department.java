package many_to_one;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	private int did;
	private String name;
	private String mname;
	private int noofemp;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getNoofemp() {
		return noofemp;
	}
	public void setNoofemp(int noofemp) {
		this.noofemp = noofemp;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", mname=" + mname + ", noofemp=" + noofemp + "]";
	}
	
	
}
