package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;

import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //DoctorDaoSQLImpl dao = new DoctorDaoSQLImpl();
        //DepartmentDaoSQLImpl departmentDaoSQL = new DepartmentDaoSQLImpl();
        PatientDaoSQLImpl patientDaoSQL = new PatientDaoSQLImpl();
        //HistoryDaoSQLImpl historyDaoSQL = new HistoryDaoSQLImpl();
        //DoctorDaoSQLImpl doctorDaoSQL = new DoctorDaoSQLImpl();
        //ddsi.add(new Department(1,"Odjel1"));
        //ddsi.add(new Department(2,"Odjel2"));
        //departmentDaoSQL.add(new Department(3, "Ortopedija"));
       // System.out.println(ddsi.getAll());
        //System.out.println(ddsi.update(new Department(2, "Radijologija")));
        //System.out.println(departmentDaoSQL.getAll());
        //System.out.println(doctorDaoSQL.getAll());
        //System.out.println(historyDaoSQL.getAll());
        //System.out.println(departmentDaoSQL.getById(1));
        /*Doctor doc1 = new Doctor();
        doc1.setId(4);
        doc1.setName("Zerina");
        doc1.setDepartment(new Department(2, "Radijologija"));
        Patient p1 = new Patient(1, "Halid", 11111111111L, doc1);
        System.out.println(p1);
        patientDaoSQL.add(p1);/*
        System.out.println(patientDaoSQL.getAll());
        /*Doctor doc1 = new Doctor();
        doc1.setId(1);
        doc1.setName("Zerina");
        doc1.setDepartment(new Department(2, "Radijologija"));
        dao.delete(4);
        //System.out.println(dao.getById(1));
        System.out.println(dao.searchByDepartment(new Department(2, "Radijologija")));

        /*DoctorDaoSQLImpl doctorDao = new DoctorDaoSQLImpl();
        doctorDao.add(new Doctor(1, "Musa Music", new Date(1,1,2001),new Department(1, "Onkologija")));
        doctorDao.add(new Doctor(2, "Huso Husic", new Date(1,2,2000),new Department(2, "Odjel2")));
        System.out.println(doctorDao.getAll());*/
    }
}
