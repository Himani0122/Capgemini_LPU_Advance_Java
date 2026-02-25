package ManyToManyLazyToEager;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Create Subjects
        Subject sub1 = new Subject();
        sub1.setId(101);
        sub1.setName("MATHS");
        sub1.setNoOfDays(3);

        Subject sub2 = new Subject();
        sub2.setId(102);
        sub2.setName("BIO");
        sub2.setNoOfDays(4);

        Subject sub3 = new Subject();
        sub3.setId(103);
        sub3.setName("CHEM");
        sub3.setNoOfDays(2);

        // Save Subjects
        Dao.insertSubject(sub1);
        Dao.insertSubject(sub2);
        Dao.insertSubject(sub3);

        // Create Students
        Student s1 = new Student();
        s1.setName("Tilak");
        s1.setBranch("Science");

        Set<Subject> set1 = new HashSet<>();
        set1.add(sub1);
        set1.add(sub2);
        s1.setSubject(set1);

        Student s2 = new Student();
        s2.setName("Ishan");
        s2.setBranch("Medical");

        Set<Subject> set2 = new HashSet<>();
        set2.add(sub2);
        set2.add(sub3);
        s2.setSubject(set2);

        // Save Students
        Dao.insertStudent(s1);
        Dao.insertStudent(s2);

        // Read
        System.out.println(Dao.findStudentById(1));
        System.out.println(Dao.findSubjectById(101));

        // Update
        Dao.updateStudent(1, "Tilak Kumar", "CSE");

        // Add existing subject to student
        Dao.addSubjectToStudent(1, 103);

        // Delete using SQL
        // StudentSubjectDAO.deleteStudentById(2);
        // StudentSubjectDAO.deleteSubjectById(102);
    }
}