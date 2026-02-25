package practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MedicalRecordDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void insertMedicalRecord(int id, String bloodG, String allergies) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        MedicalRecord mr = new MedicalRecord();
        mr.setId(id);
        mr.setBloodG(bloodG);
        mr.setAllergies(allergies);

        et.begin();
        em.persist(mr);
        et.commit();
        em.close();
    }

    public static MedicalRecord findMedicalRecord(int id) {
        EntityManager em = emf.createEntityManager();
        MedicalRecord mr = em.find(MedicalRecord.class, id);
        em.close();
        return mr;
    }

    public static void updateMedicalRecord(int id, String bloodG, String allergies) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        MedicalRecord mr = em.find(MedicalRecord.class, id);
        if (mr != null) {
            et.begin();
            mr.setBloodG(bloodG);
            mr.setAllergies(allergies);
            et.commit();
        }
        em.close();
    }

    public static void deleteMedicalRecord(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        MedicalRecord mr = em.find(MedicalRecord.class, id);
        if (mr != null) {
            et.begin();
            em.remove(mr);
            et.commit();
        }
        em.close();
    }
}
