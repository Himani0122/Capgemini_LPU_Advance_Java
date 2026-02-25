package practice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        HospitalService service = new HospitalService();

        service.registerPatientWithRecord(1, "Miller", 20, 1234, 11, "B+", "Dust");
        service.registerPatientWithRecord(2, "John", 25, 5678, 12, "O+", "None");

        service.assignAppointmentToPatient(101, "2026-02-14", 500, 1);
        service.assignAppointmentToPatient(102, "2026-02-15", 700, 2);

        service.addAppointmentsToDoctor(201, "Dr. Smith", "Cardiology", Arrays.asList(101, 102));

        Doctor d = service.fetchDoctor(201);
        System.out.println(d);

        service.updateAppointmentFee(101, 650);

        service.deleteAppointment(102);

        service.deletePatient(2);

        service.deleteDoctor(201);
    }
}