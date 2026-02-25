package ManyToOneByDefaultEagerToLazy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "number_sequence")
	@SequenceGenerator(name="number_sequence",sequenceName = "number_sequence",initialValue = 100,allocationSize=1)
	private int id;
	private String name;
	private int numberEmp;
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
	public int getNumberEmp() {
		return numberEmp;
	}
	public void setNumberEmp(int numberEmp) {
		this.numberEmp = numberEmp;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", numberEmp=" + numberEmp + "]";
	}
	

}
