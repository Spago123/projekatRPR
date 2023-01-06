package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.exceptions.HospitalException;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoSQLImpl implements DoctorDao{
    private Connection connection;

    public DoctorDaoSQLImpl(){
        try{
            this.connection = DataBaseDao.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Doctor getById(int id) {
        String query = "SELECT * FROM Doctors WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getNString("name"));
                doctor.setDepartment(new DepartmentDaoSQLImpl().getById(rs.getInt("idDepartment")));
                rs.close();
                return doctor;
            }else{
                return null;
            }
        } catch (SQLException | HospitalException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Doctor add(Doctor item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement( "INSERT INTO Doctors(name, idDepartment) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getDepartment().getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            item.setId(rs.getInt(1));
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Doctor update(Doctor item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Doctors SET name=?, idDepartment=? WHERE id=?");
            stmt.setInt(3,item.getId());
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getDepartment().getId());
            stmt.executeUpdate();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Doctors WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from Doctors");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setDepartment(new DepartmentDaoSQLImpl().getById(rs.getInt("idDepartment")));
                doctors.add(doctor);
            }
            rs.close();
        } catch (SQLException | HospitalException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    ////OSTALO TI JE OVO OVDJE
    @Override
    public List<Doctor> searchByDepartment(Department department) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Doctors WHERE idDepartment = ?");
            stmt.setInt(1, department.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setDepartment(department);
                doctors.add(doctor);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
