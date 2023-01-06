package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.DiagnosisManager;
import ba.unsa.etf.rpr.controllers.components.OneButtonCellFactory;
import ba.unsa.etf.rpr.controllers.components.OneButtonTableCell;
import ba.unsa.etf.rpr.domain.History;
import ba.unsa.etf.rpr.domain.Patient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PatientHomeController {

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

    public void initialize(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        view.setCellValueFactory(new PropertyValueFactory<>("id"));

        view.setCellFactory(new OneButtonCellFactory(viewEvent -> {
            int historyId = Integer.parseInt(((Button)viewEvent.getSource()).getUserData().toString());
            showHistoryScene(historyId);
        }));

        updateHistories();
    }

    private void updateHistories() {
        patientDiagnosisView.setItems(FXCollections.observableList(diagnosisManager.getAll()));
        patientDiagnosisView.refresh();
    }

    private void showHistoryScene(int historyId) {
        ViewHistoryController viewHistoryController = new ViewHistoryController();
        new OpenNewWindow<>().openDialog(AppFX.getPageTitle("viewHistory"), "/fxml/viewHistory.fxml", viewHistoryController, (Stage) patientUIN.getScene().getWindow());
    }

    public void editPersonalInfo(ActionEvent actionEvent) {
        EditPasswordController editPasswordController = new EditPasswordController<Patient>(new Patient());
        new OpenNewWindow<>().openDialog(AppFX.getPageTitle("editPass"), "/fxml/editPass.fxml", editPasswordController, (Stage) patientUIN.getScene().getWindow());
    }
}
