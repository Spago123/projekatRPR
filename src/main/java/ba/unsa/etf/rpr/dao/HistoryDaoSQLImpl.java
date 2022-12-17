package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.History;
import ba.unsa.etf.rpr.domain.Patient;

import javax.swing.event.HyperlinkEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDaoSQLImpl implements HistoryDao{

    private Connection connection;

    public HistoryDaoSQLImpl(){
        try{
            this.connection = DataBaseDao.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public History getById(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setPatient(new PatientDaoSQLImpl().getById(rs.getInt("idPatient")));
                history.setDoctor(new DoctorDaoSQLImpl().getById(rs.getInt("idDoctor")));
                history.setDiagnosis(rs.getString("diagnosis"));
                rs.close();
                return history;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public History add(History item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement( "INSERT INTO Histories(idDoctor, idPatient, diagnosis) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, item.getDoctor().getId());
            stmt.setInt(2, item.getPatient().getId());
            stmt.setString(3, item.getDiagnosis());
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
    public History update(History item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Histories SET idPatient=?, idDoctor=?, diagnosis=? WHERE id=?");
            stmt.setInt(5,item.getId());
            stmt.setInt(1, item.getPatient().getId());
            stmt.setInt(2, item.getDoctor().getId());
            stmt.setString(3, item.getDiagnosis());
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
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Histories WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<History> getAll() {
        List<History> histories = new ArrayList<History>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setPatient(new PatientDaoSQLImpl().getById(rs.getInt("idPatient")));
                history.setDoctor(new DoctorDaoSQLImpl().getById(rs.getInt("idDoctor")));
                history.setDiagnosis(rs.getString("diagnosis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    @Override
    public List<History> searchByPatient(Patient patient) {
        List<History> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE idPatient = ?");
            stmt.setInt(1, patient.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setPatient(patient);
                history.setId(rs.getInt("id"));
                history.setDoctor(new DoctorDaoSQLImpl().getById(rs.getInt("idDoctor")));
                history.setDiagnosis(rs.getString("diagnosis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    @Override
    public List<History> searchByDoctor(Doctor doctor) {
        List<History> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE idDoctor = ?");
            stmt.setInt(1, doctor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setDoctor(doctor);
                history.setId(rs.getInt("id"));
                history.setPatient(new PatientDaoSQLImpl().getById(rs.getInt("idPatient")));
                history.setDiagnosis(rs.getString("diagnosis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    @Override
    public List<History> searchByDoctorAndPatient(Doctor doctor, Patient patient) {
        List<History> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE idPatient = ? AND idDoctor = ?");
            stmt.setInt(1, patient.getId());
            stmt.setInt(2, doctor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setPatient(patient);
                history.setDoctor(doctor);
                history.setId(rs.getInt("id"));
                history.setDiagnosis(rs.getString("diagnosis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }
}
