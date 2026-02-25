package practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void savePatient(int id, int contact, int age, String name, MedicalRecord medicalRecord) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient patient = new Patient();
        patient.setId(id);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setName(name);
        patient.setRecord(medicalRecord);

        et.begin();
        em.persist(patient);
        et.commit();
        em.close();
    }

    public static Patient findPatient(int id) {
        EntityManager em = emf.createEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public static void updatePatient(int id, String name, int age) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient p = em.find(Patient.class, id);
        if (p != null) {
            et.begin();
            p.setName(name);
            p.setAge(age);
            et.commit();
        }
        em.close();
    }

    public static void deletePatient(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient p = em.find(Patient.class, id);
        if (p != null) {
            et.begin();
            em.remove(p);
            et.commit();
        }
        em.close();
    }
}
