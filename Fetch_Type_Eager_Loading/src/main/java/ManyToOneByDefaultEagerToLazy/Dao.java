package ManyToOneByDefaultEagerToLazy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

    public static void insertDepartment(Department d) {
        et.begin();
        em.persist(d);
        et.commit();
    }

    public static void insertEmployee(Employee e) {
        et.begin();
        em.persist(e);
        et.commit();
    }

    public static Department findDepartmentById(int id) {
        return em.find(Department.class, id);
    }

    public static Employee findEmployeeById(int id) {
        return em.find(Employee.class, id);
    }

    public static boolean updateDepartment(int id, String newName, int newCount) {
        Department d = em.find(Department.class, id);
        if (d != null) {
            et.begin();
            d.setName(newName);
            d.setNumberEmp(newCount);
            et.commit();
            return true;
        }
        return false;
    }

    public static boolean updateEmployee(int id, String newName, double newSal) {
        Employee e = em.find(Employee.class, id);
        if (e != null) {
            et.begin();
            e.setName(newName);
            e.setSal(newSal);
            et.commit();
            return true;
        }
        return false;
    }

    public static void deleteEmployeeById(int id) {
        Employee e = em.find(Employee.class, id);
        if (e != null) {
            et.begin();
            em.remove(e);
            et.commit();
        }
    }

    public static void deleteDepartmentById(int id) {

        String sql1 = "update Employee set d_id = null where d_id = ?1";
        String sql2 = "delete from Department where id = ?1";

        et.begin();

        em.createNativeQuery(sql1)
          .setParameter(1, id)
          .executeUpdate();

        em.createNativeQuery(sql2)
          .setParameter(1, id)
          .executeUpdate();

        et.commit();
    }
}
