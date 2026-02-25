package DAO;

import javax.persistence.*;

public class AppointmentDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");

    public void insert(String time, String status, int doctorId, int prescriptionId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query q = em.createNativeQuery("INSERT INTO appointment(time, status, doctor_id, prescription_id) VALUES(?,?,?,?)");
        q.setParameter(1, time);
        q.setParameter(2, status);
        q.setParameter(3, doctorId);
        q.setParameter(4, prescriptionId);
        q.executeUpdate();

        et.commit();
        em.close();
    }
}