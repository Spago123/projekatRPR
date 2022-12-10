package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;

import java.util.List;

public interface DoctorDao extends Dao<Doctor>{
    /**
     * Method that lets you search the Doctors table by their department id
     * @param department department name
     * @return  list of doctors that belong to that department
     */
    List<Doctor> searchByDepartment(Department department);
}
