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
            this.connection = DriverManager.getConnection("","","");
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
                patient.setDateOfBirth(rs.getDate("startedWork"));
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

    private int getMaxId(){
        int id=1;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT MAX(id)+1 FROM Patients");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                rs.close();
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public Patient add(Patient item) {
        int id = getMaxId();
        try{
            PreparedStatement stmt =  this.connection.prepareStatement("INSERT INTO Patients VALUES (id, item.getName(), item.getDateOfBirth(), item.getUIN(), item.getDoctor().getId())");
            stmt.executeUpdate();
            item.setId(id);
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Patient update(Patient item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Patients SET name=?, dateOfBirth=?, UIN=?, idDoctors=? WHERE id=?");
            stmt.setInt(5,item.getId());
            stmt.setString(1, item.getName());
            stmt.setDate(2, (Date)item.getDateOfBirth());
            stmt.setInt(3, (int)item.getUIN());
            stmt.setInt(4, item.getDoctor().getId());
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
                patient.setDateOfBirth(rs.getDate("dateOfBirth"));
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
                patient.setDateOfBirth(rs.getDate("dateOfBirth"));
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
