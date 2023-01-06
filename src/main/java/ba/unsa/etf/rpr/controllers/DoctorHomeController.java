package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.Doc;

public class DoctorHomeController {

    private PatientManager patientManager = new PatientManager();
    public TableView<Patient> myPatients;
    public TableColumn<Patient, Integer> id;
    public TableColumn<Patient, String> patientName;
    public TableColumn<Patient, Integer> UIN;

    @FXML
    private void initialize() throws HospitalException {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        UIN.setCellValueFactory(new PropertyValueFactory<>("UIN"));

        refreshPatients();
    }

    private void refreshPatients() throws HospitalException {

        Department department1 = new Department(1, "Onkologija");
        Department department2 = new Department(2, "Kardiologija");

        Doctor doctor1 = new Doctor(1, "Huso Husic", department1);
        myPatients.setItems(FXCollections.observableList(patientManager.getByDoctor(doctor1)));
        myPatients.refresh();
    }
}
