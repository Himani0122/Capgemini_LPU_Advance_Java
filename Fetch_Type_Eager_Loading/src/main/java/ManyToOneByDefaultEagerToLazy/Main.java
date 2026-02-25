package ManyToOneByDefaultEagerToLazy;

public class Main {
    public static void main(String[] args) {

        Department d1 = new Department();
        //d1.setId(101);
        d1.setName("D1");
        d1.setNumberEmp(32);

        Department d2 = new Department();
        //d2.setId(102);
        d2.setName("D2");
        d2.setNumberEmp(26);

        Department d3 = new Department();
        //d3.setId(103);
        d3.setName("D3");
        d3.setNumberEmp(18);

        EmployeeDepartmentDAO.insertDepartment(d1);
        EmployeeDepartmentDAO.insertDepartment(d2);
        EmployeeDepartmentDAO.insertDepartment(d3);

        Employee e1 = new Employee();
        //e1.setId(1);
        e1.setName("Miller");
        e1.setSal(35000);
        e1.setDesignation("Manager");
        e1.setD(d1);

        Employee e2 = new Employee();
        //e2.setId(2);
        e2.setName("Rohit");
        e2.setSal(25000);
        e2.setDesignation("Developer");
        e2.setD(d1);

        Employee e3 = new Employee();
        //e3.setId(3);
        e3.setName("Aman");
        e3.setSal(28000);
        e3.setDesignation("Tester");
        e3.setD(d1);

        Employee e4 = new Employee();
        //e4.setId(4);
        e4.setName("John");
        e4.setSal(30000);
        e4.setDesignation("Developer");
        e4.setD(d2);

        Employee e5 = new Employee();
        //e5.setId(5);
        e5.setName("Sara");
        e5.setSal(32000);
        e5.setDesignation("HR");
        e5.setD(d2);

        Employee e6 = new Employee();
        //e6.setId(6);
        e6.setName("Neha");
        e6.setSal(27000);
        e6.setDesignation("Support");
        e6.setD(d3);

        Employee e7 = new Employee();
        //e7.setId(7);
        e7.setName("Arjun");
        e7.setSal(40000);
        e7.setDesignation("Lead");
        e7.setD(d3);

        Dao.insertEmployee(e1);
        Dao.insertEmployee(e2);
        Dao.insertEmployee(e3);
        Dao.insertEmployee(e4);
        Dao.insertEmployee(e5);
        Dao.insertEmployee(e6);
        Dao.insertEmployee(e7);
        
        Dao.updateEmployee(1, "Miller Updated", 45000);
        Dao.deleteEmployeeById(7);
        Dao.deleteDepartmentById(103);
    }
}
