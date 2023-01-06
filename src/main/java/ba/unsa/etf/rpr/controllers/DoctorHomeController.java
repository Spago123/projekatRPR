package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.controllers.components.OneButtonCellFactory;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.History;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.Doc;

public class DoctorHomeController {

    public Label doctorName;
    public TextField department;
    public TextField password;

    //First table
    public TableView myPatients;
    public TableColumn<Patient, String> patientName;
    public TableColumn<Patient, Long> patientUIN;
    public TableColumn<Patient, Integer> addNew;
    public Button addPatient;


    //Second Table
    public TableView myDiagnosis;
    public TableColumn<History, String> patientNameTab2;
    public TableColumn<History, String> diagnosisTab2;
    public TableColumn<History, Integer> viewTab2;
    private PatientManager patientManager = new PatientManager();


    @FXML
    private void initialize() throws HospitalException {
        
        patientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        patientUIN.setCellValueFactory(new PropertyValueFactory<>("UIN"));
        patientUIN.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        patientUIN.setCellFactory(new OneButtonCellFactory(addEvent -> {
            int patientId = Integer.parseInt(((Button)addEvent.getSource()).getUserData().toString());
            addNewDiagnosis(patientId);
        }));

        refreshPatients();
        
        patientNameTab2.setCellValueFactory(new PropertyValueFactory<>("patient"));
        diagnosisTab2.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        viewTab2.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        viewTab2.setCellFactory(new OneButtonCellFactory(viewEvent -> {
            int historyId = Integer.parseInt(((Button)viewEvent.getSource()).getUserData().toString());
            showHistroy(historyId);
        }));
        
        refreshDiagnosis();
    }

    private void refreshDiagnosis() {
    }

    private void showHistroy(int historyId) {
    }

    private void addNewDiagnosis(int patientId) {
    }

    private void refreshPatients() throws HospitalException {

        Department department1 = new Department(1, "Onkologija");
        Department department2 = new Department(2, "Kardiologija");

        Doctor doctor1 = new Doctor(1, "Huso Husic", department1);
        myPatients.setItems(FXCollections.observableList(patientManager.getByDoctor(doctor1)));
        myPatients.refresh();
    }

    public void addPatient(ActionEvent actionEvent) {
    }
}
