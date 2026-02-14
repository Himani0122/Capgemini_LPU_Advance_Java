package EcommerceOrderModule;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private int id;
	private String name;
	private String email;
	
	@OneToOne
	Profile p;
	
	public Profile getP() {
		return p;
	}
	public void setP(Profile p) {
		this.p = p;
	}
	
	@OneToMany
	List<PurchaseOrder> l;
	
	public List<PurchaseOrder> getL() {
		return l;
	}
	public void setL(List<PurchaseOrder> l) {
		this.l = l;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", p=" + p + ", l=" + l + "]";
	}
	
	
}
