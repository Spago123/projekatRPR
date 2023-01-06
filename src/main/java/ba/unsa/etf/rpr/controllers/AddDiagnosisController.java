package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import ba.unsa.etf.rpr.AppFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.print.Doc;
import java.io.IOException;

public class AddDiagnosisController {

    public TextField patientName;
    public TextArea diagnosis;
    public Button save;
    public Button exit;


    @FXML
    private void initialize(){
    }

    @FXML
    private void save(ActionEvent actionEvent) {
        DoctorHomeController doctorHomeController = new DoctorHomeController();
        new OpenNewWindow().openDialog(AppFX.getPageTitle("doctorHome"), "/fxml/doctorHome.fxml", doctorHomeController, (Stage) save.getScene().getWindow());
    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        DoctorHomeController doctorHomeController = new DoctorHomeController();
        new OpenNewWindow().openDialog( AppFX.getPageTitle("doctorHome"), "/fxml/doctorHome.fxml", doctorHomeController, (Stage) save.getScene().getWindow());
    }
}
