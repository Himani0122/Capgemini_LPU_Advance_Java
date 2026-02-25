package practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecord {

    @Id
    private int id;
    private String bloodG;
    private String allergies;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBloodG() { return bloodG; }
    public void setBloodG(String bloodG) { this.bloodG = bloodG; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    @Override
    public String toString() {
        return "MedicalRecord [id=" + id + ", bloodG=" + bloodG + ", allergies=" + allergies + "]";
    }
}
