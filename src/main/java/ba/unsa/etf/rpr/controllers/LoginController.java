package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.domain.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginController {

    private PatientManager patientManager = new PatientManager();
    public Button login;
    public TextField username;
    public PasswordField password;

    @FXML
    private void initialize(){
        
    }

    @FXML
    private void login(ActionEvent actionEvent) throws IOException {

        List<Patient> patient = (List<Patient>) patientManager.getByNameAndPass(username.getText(), password.getText());
        if (patient.size() == 0) {
            System.out.println("nista");
        } else {
            PatientHomeController patientHomeController = new PatientHomeController(patient.get(0));
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("patientHome"), "/fxml/patientHome.fxml",
                    patientHomeController, (Stage) username.getScene().getWindow());
        }

    }
}
