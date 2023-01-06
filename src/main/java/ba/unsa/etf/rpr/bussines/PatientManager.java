package ba.unsa.etf.rpr.bussines;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;

import java.util.List;

public class PatientManager {

    DaoFactory daoFactory = new DaoFactory();
;
    public List<Patient> getByDoctor(Doctor doctor) throws HospitalException {
        return daoFactory.patientDao().searchByDoctor(doctor);
    }

    public List<Patient> getAll() throws HospitalException {
        return daoFactory.patientDao().getAll();
    }

    public void addPatient(Patient patient) throws HospitalException {
        daoFactory.patientDao().add(patient);
    }
}
