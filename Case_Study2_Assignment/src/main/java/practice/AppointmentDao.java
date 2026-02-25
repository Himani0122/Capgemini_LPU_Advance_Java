package practice;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppointmentDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void insertAppointment(int id, String visitDate, double fee, Patient patient) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Appointment a = new Appointment();
        a.setId(id);
        a.setVisitDate(visitDate);
        a.setFee(fee);
        a.setPatient(patient);

        et.begin();
        em.persist(a);
        et.commit();
        em.close();
    }

    public static Appointment findAppointment(int id) {
        EntityManager em = emf.createEntityManager();
        Appointment a = em.find(Appointment.class, id);
        em.close();
        return a;
    }

    public static void updateFee(int id, double fee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Appointment a = em.find(Appointment.class, id);
        if (a != null) {
            et.begin();
            a.setFee(fee);
            et.commit();
        }
        em.close();
    }

    public static void deleteAppointment(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.createNativeQuery("delete from Doctor_Appointment where list_id = ?1")
          .setParameter(1, id)
          .executeUpdate();

        em.createNativeQuery("delete from Appointment where id = ?1")
          .setParameter(1, id)
          .executeUpdate();

        et.commit();
        em.close();
    }
}
