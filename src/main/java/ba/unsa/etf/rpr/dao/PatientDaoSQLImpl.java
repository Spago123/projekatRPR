package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoSQLImpl implements PatientDao {

    private Connection connection;

    public PatientDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Patient getById(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Patients WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getNString("name"));
                patient.setUIN(rs.getInt("UIN"));
                patient.setDoctor(new DoctorDaoSQLImpl().getById(rs.getInt("idDoctor")));
                rs.close();
                return patient;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Patient add(Patient item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement( "INSERT INTO Patients(name, UIN, idDoctor) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.setInt(2, (int)item.getUIN());
            stmt.setInt(3, item.getDoctor().getId());
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
    public Patient update(Patient item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Patients SET name=?, UIN=?, idDoctors=? WHERE id=?");
            stmt.setInt(4,item.getId());
            stmt.setString(1, item.getName());
            stmt.setInt(2, (int)item.getUIN());
            stmt.setInt(3, item.getDoctor().getId());
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
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Patients WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<Patient>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from Patients");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setDoctor(new DoctorDaoSQLImpl().getById(rs.getInt("idDoctor")));
                patients.add(patient);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    ///IMAS JOS OVO OVDJE
    @Override
    public List<Patient> searchByDoctor(Doctor doctor) {
        List<Patient> patients = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Patients WHERE idDoctor = ?");
            stmt.setInt(1, doctor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setUIN(rs.getInt("UIN"));
                patient.setDoctor(doctor);
                patients.add(patient);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
