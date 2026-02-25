package Entities;


import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    private int id;

    private String time;
    private String status;

    @OneToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Appointment() {}

    public int getId() { return id; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Prescription getPrescription() { return prescription; }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}