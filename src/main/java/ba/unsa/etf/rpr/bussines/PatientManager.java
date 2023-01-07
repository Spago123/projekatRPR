package ba.unsa.etf.rpr.bussines;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;

import java.util.List;

public class PatientManager {

    //DaoFactory daoFactory = new DaoFactory();
;
    public List<Patient> getByDoctor(Doctor doctor) throws HospitalException {
        return DaoFactory.patientDao().searchByDoctor(doctor);
    }

    public List<Patient> getAll() throws HospitalException {
        return DaoFactory.patientDao().getAll();
    }

    public void addPatient(Patient patient) throws HospitalException {
        DaoFactory.patientDao().add(patient);
    }

    public void updatePatient(Patient patient) throws HospitalException {
        DaoFactory.patientDao().update(patient);
    }

    public Patient getById(int id) throws HospitalException {
        return DaoFactory.patientDao().getById(id);
    }

    public List<Patient> getByNameAndPass(String name, String pass){
        return DaoFactory.patientDao().searchByNameAndPass(name, pass);
    }
}
