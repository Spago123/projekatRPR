package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.DiagnosisManager;
import ba.unsa.etf.rpr.controllers.components.OneButtonCellFactory;
import ba.unsa.etf.rpr.controllers.components.OneButtonTableCell;
import ba.unsa.etf.rpr.domain.History;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PatientHomeController {

    private Patient patient;

    private DiagnosisManager diagnosisManager = new DiagnosisManager();

    public Tab personalInfo;
    public Button editPersonalInfo;
    public TextField patientUIN;
    public TextField patientDoctor;
    public Label welcomeName;


    public TableView patientDiagnosisView;
    public TableColumn<History, Integer> id;
    public TableColumn<History, String> doctor;
    public TableColumn<History, String> diagnosis;
    public TableColumn<History, Integer> view;

    public PatientHomeController(Patient patient){
        this.patient = patient;
    }

    public void initialize(){
        welcomeName.setText(patient.getName());
        patientUIN.setText(String.valueOf(patient.getUIN()));
        patientDoctor.setText(patient.getDoctor().getName());


        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        view.setCellValueFactory(new PropertyValueFactory<>("id"));

        view.setCellFactory(new OneButtonCellFactory(viewEvent -> {
            int historyId = Integer.parseInt(((Button)viewEvent.getSource()).getUserData().toString());
            showHistoryScene(historyId);
        }, "View"));

        updateHistories();
    }

    private void updateHistories() {
        patientDiagnosisView.setItems(FXCollections.observableList(diagnosisManager.getByPatient(patient)));
        patientDiagnosisView.refresh();
    }

    private void showHistoryScene(int historyId) {
        try {
            ViewHistoryController viewHistoryController = new ViewHistoryController<Patient>(diagnosisManager.getById(historyId), patient);
            new OpenNewWindow<>().openDialog("viewHistory", "/fxml/viewHistory.fxml", viewHistoryController, (Stage) patientUIN.getScene().getWindow());
        } catch (HospitalException e) {
            throw new RuntimeException(e);
        }
    }

    public void editPersonalInfo(ActionEvent actionEvent) {
        EditPasswordController editPasswordController = new EditPasswordController<Patient>(patient);
        new OpenNewWindow<>().openDialog("editPass", "/fxml/editPass.fxml", editPasswordController, (Stage) patientUIN.getScene().getWindow());
    }
}
