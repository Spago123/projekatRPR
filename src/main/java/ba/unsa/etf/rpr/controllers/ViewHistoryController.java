package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.domain.History;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHistoryController {
    public TextField patientName;
    public TextField doctorName;
    public Button exit;
    public TextArea diagnosis;
    private History history;

    public ViewHistoryController(){

    }
    public ViewHistoryController(History history){
        this.history = history;
    }

    @FXML
    private void initialize(){
        patientName.setText(history.getPatient().getName());
        doctorName.setText(history.getDoctor().getName());
        diagnosis.setText(history.getDiagnosis());
    }

    public void exitButton(ActionEvent actionEvent) throws IOException {
        PatientHomeController patientHomeController = new PatientHomeController();
        //patientHomeController.setName(history.getPatient().getName());
        new OpenNewWindow().openDialog(AppFX.getPageTitle("patientHome"), "/fxml/patientHome.fxml", patientHomeController, (Stage) patientName.getScene().getWindow());
    }
}
