package Entities;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {}

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Doctor> getDoctors() { return doctors; }
}