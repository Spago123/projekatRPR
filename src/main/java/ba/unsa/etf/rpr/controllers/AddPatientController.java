package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class AddPatientController {

    public Button exit;
    private PatientManager patientManager= new PatientManager();
    public TextField patientsName;
    public TextField patientsUIN;
    
    
    public Button add;

    @FXML
    private void initialize(){

    }

    @FXML
    private void exitBtn(ActionEvent actionEvent) {
        new OpenNewWindow().openDialog(AppFX.getPageTitle("doctorHome"), "/fxml/doctorHome.fxml", new DoctorHomeController(), (Stage) add.getScene().getWindow());

    }

    @FXML
    private void addBtn(ActionEvent actionEvent) throws HospitalException {
        Department department = new Department(1, "Onkologija");
        Doctor doctor = new Doctor(1, "Velid Velic", department);
        patientManager.addPatient(new Patient(1, patientsName.getText(), Long.parseLong(patientsUIN.getText()), doctor));
        new OpenNewWindow().openDialog(AppFX.getPageTitle("doctorHome"), "/fxml/doctorHome.fxml", new DoctorHomeController(), (Stage) add.getScene().getWindow());

    }
}
