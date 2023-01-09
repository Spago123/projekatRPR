package ba.unsa.etf.rpr.bussines;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.exceptions.HospitalException;

import java.util.List;

public class DoctorManager {

    public void updateDoctor(Doctor doctor) throws HospitalException {
        DaoFactory.doctorDao().update(doctor);
    }

    public List<Doctor> getByNameAndPass(String name, String pass){
        return DaoFactory.doctorDao().searchByNameAndPassword(name, pass);
    }
}
