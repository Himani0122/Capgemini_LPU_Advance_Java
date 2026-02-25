package ManyToManyLazyToEager;

import java.util.List;
import javax.persistence.*;

public class Dao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

    // ✅ Insert Student
    public static void insertStudent(Student s) {
        et.begin();
        em.persist(s);
        et.commit();
        System.out.println("Student inserted");
    }

    // ✅ Insert Subject
    public static void insertSubject(Subject sub) {
        et.begin();
        em.persist(sub);
        et.commit();
        System.out.println("Subject inserted");
    }

    // ✅ Find Student by Id
    public static Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    // ✅ Find Subject by Id
    public static Subject findSubjectById(int id) {
        return em.find(Subject.class, id);
    }

    // ✅ Update Student
    public static boolean updateStudent(int id, String newName, String newBranch) {
        Student s = em.find(Student.class, id);
        if (s != null) {
            et.begin();
            s.setName(newName);
            s.setBranch(newBranch);
            et.commit();
            System.out.println("Student updated");
            return true;
        }
        System.out.println("Student not found");
        return false;
    }

    // ✅ Delete Student by Id (SQL + setParameter)
    public static void deleteStudentById(int id) {

        String sql1 = "delete from student_subject where student_id = ?1";
        String sql2 = "delete from student where id = ?1";

        Query q1 = em.createNativeQuery(sql1);
        Query q2 = em.createNativeQuery(sql2);

        q1.setParameter(1, id);
        q2.setParameter(1, id);

        et.begin();
        q1.executeUpdate();   // delete join table rows
        q2.executeUpdate();   // delete student
        et.commit();

        System.out.println("Student deleted");
    }

    // ✅ Delete Subject by Id (SQL + setParameter)
    public static void deleteSubjectById(int id) {

        String sql1 = "delete from student_subject where subject_id = ?1";
        String sql2 = "delete from subject where id = ?1";

        Query q1 = em.createNativeQuery(sql1);
        Query q2 = em.createNativeQuery(sql2);

        q1.setParameter(1, id);
        q2.setParameter(1, id);

        et.begin();
        q1.executeUpdate();   // delete join table rows
        q2.executeUpdate();   // delete subject
        et.commit();

        System.out.println("Subject deleted");
    }

    // ✅ Add existing Subject to Student
    public static boolean addSubjectToStudent(int studentId, int subjectId) {

        Student s = em.find(Student.class, studentId);
        Subject sub = em.find(Subject.class, subjectId);

        if (s != null && sub != null) {
            s.getSubject().add(sub);

            et.begin();
            em.merge(s);
            et.commit();

            System.out.println("Subject added to student");
            return true;
        }

        System.out.println("Student or Subject not found");
        return false;
    }
}