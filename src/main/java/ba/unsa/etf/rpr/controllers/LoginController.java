package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public Button login;
    public TextField username;
    public PasswordField password;

    @FXML
    private void initialize(){
        
    }

    @FXML
    private void login(ActionEvent actionEvent) throws IOException {
        PatientHomeController patientHomeController = new PatientHomeController();
        System.out.println(username.getText());
        //patientHomeController.setName(username.getText());
        //System.out.println(patientHomeController.welcomeName.getText());
        new OpenNewWindow().openDialog( AppFX.getPageTitle("patientHome"), "/fxml/patientHome.fxml", patientHomeController, (Stage) login.getScene().getWindow());
        /*DoctorHomeController doctorHomeController = new DoctorHomeController();
        new OpenNewWindow<DoctorHomeController>().openDialog("Doctor Page", "/fxml/doctorHome.fxml", doctorHomeController, (Stage) password.getScene().getWindow());*/
    }
}
