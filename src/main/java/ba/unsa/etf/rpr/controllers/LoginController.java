package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.DoctorManager;
import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;

public class LoginController {

    private PatientManager patientManager = new PatientManager();
    private DoctorManager doctorManager = new DoctorManager();
    public Button login;
    public TextField username;
    public PasswordField password;

    @FXML
    private void initialize(){
        
    }

    @FXML
    private void login(ActionEvent actionEvent) throws IOException, HospitalException {

        List<Patient> patient = patientManager.getByNameAndPass(username.getText(), password.getText());
        if (patient.size() != 0) {
            PatientHomeController patientHomeController = new PatientHomeController(patient.get(0));
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("patientHome"), "/fxml/patientHome.fxml",
                    patientHomeController, (Stage) username.getScene().getWindow());
            return;
        }


        List<Doctor> doctors = doctorManager.getByNameAndPass(username.getText(), password.getText());
        if(doctors!=null){
            DoctorHomeController doctorHomeController = new DoctorHomeController(doctors.get(0));
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("doctorHome"), "/fxml/doctorHome.fxml", doctorHomeController, (Stage) username.getScene().getWindow());
        }

    }
}
