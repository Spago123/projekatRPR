package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.History;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args ) throws HospitalException {
        Department department1 = new Department(1, "Onkologija");
        Department department2 = new Department(2, "Kardiologija");

        Doctor doctor1 = new Doctor(1, "Huso Husic", department1);
        Doctor doctor2 = new Doctor(2, "Meho Mehic", department2);
        Doctor doctor3 = new Doctor(3, "Zulfo Zulfic", department1);
        Doctor doctor4 = new Doctor(4, "Kemo Kemic", department2);

        Patient patient1 = new Patient(7, "Hamo Hamic", 111111111111L, doctor1);
        Patient patient2 = new Patient(2, "Vaso Vasic", 222222222222L, doctor1);
        Patient patient3 = new Patient(9, "Lelo Lelic", 333333333333L, doctor3);

        History history1 = new History(1, patient1, doctor1, "Upala uha");
        History history2 = new History(2, patient3, doctor1, "Upala grla");

        DepartmentDaoSQLImpl departmentDaoSQL = new DepartmentDaoSQLImpl();
        DoctorDaoSQLImpl doctorDaoSQL = new DoctorDaoSQLImpl();
        PatientDaoSQLImpl patientDaoSQL = new PatientDaoSQLImpl();
        HistoryDaoSQLImpl historyDaoSQL = new HistoryDaoSQLImpl();

        doctor1.setDepartment(department2);
        doctorDaoSQL.update(doctor1);

        System.out.println(doctorDaoSQL.getAll());
        System.out.println(patientDaoSQL.getAll());
        System.out.println(historyDaoSQL.getAll());
    }
}
