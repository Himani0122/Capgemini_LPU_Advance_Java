package MainClass;

import DAO.AppointmentDao;
import DAO.DepartmentDAO;
import DAO.DoctorDAO;
import DAO.MedicalRecordDAO;
import DAO.PatientDAO;
import DAO.PrescriptionDAO;

public class Main {

    public static void main(String[] args) {

        MedicalRecordDAO mrDao = new MedicalRecordDAO();
        DepartmentDAO deptDao = new DepartmentDAO();
        PrescriptionDAO presDao = new PrescriptionDAO();
        PatientDAO patientDao = new PatientDAO();
        DoctorDAO doctorDao = new DoctorDAO();
        AppointmentDao apptDao = new AppointmentDao();

        mrDao.insert("Fever", "Rest 3 days");
        deptDao.insert("Cardiology");
        presDao.insert("Paracetamol", "2 times a day");

        patientDao.insert("Rahul", "9999999999", 1);
        patientDao.updatePhone(1, "8888888888");

        apptDao.insert("10:30 AM", "SCHEDULED", 1, 1);

        patientDao.projectNames();
        doctorDao.projectNames();

        patientDao.delete(1);

    }
}