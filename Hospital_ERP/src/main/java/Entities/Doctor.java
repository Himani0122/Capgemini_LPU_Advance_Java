package Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor() {}

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Appointment> getAppointments() { return appointments; }
}