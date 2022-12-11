package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DepartmentDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DoctorDaoSQLImpl;
import ba.unsa.etf.rpr.dao.HistoryDaoSQLImpl;
import ba.unsa.etf.rpr.dao.PatientDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        DepartmentDaoSQLImpl departmentDaoSQL = new DepartmentDaoSQLImpl();
        PatientDaoSQLImpl patientDaoSQL = new PatientDaoSQLImpl();
        HistoryDaoSQLImpl historyDaoSQL = new HistoryDaoSQLImpl();
        DoctorDaoSQLImpl doctorDaoSQL = new DoctorDaoSQLImpl();
        //ddsi.add(new Department(1,"Odjel1"));
        //ddsi.add(new Department(2,"Odjel2"));
        //departmentDaoSQL.add(new Department(3, "Ortopedija"));
       // System.out.println(ddsi.getAll());
        //System.out.println(ddsi.update(new Department(2, "Radijologija")));
        System.out.println(departmentDaoSQL.getAll());
        System.out.println(doctorDaoSQL.getAll());
        //System.out.println(historyDaoSQL.getAll());
        //System.out.println(patientDaoSQL.getAll());

        /*DoctorDaoSQLImpl doctorDao = new DoctorDaoSQLImpl();
        doctorDao.add(new Doctor(1, "Musa Music", new Date(1,1,2001),new Department(1, "Onkologija")));
        doctorDao.add(new Doctor(2, "Huso Husic", new Date(1,2,2000),new Department(2, "Odjel2")));
        System.out.println(doctorDao.getAll());*/
    }
}
