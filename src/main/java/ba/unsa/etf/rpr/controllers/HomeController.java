package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {
    @FXML
    private void initialize(){
    }

    @FXML
    private void loginButton(javafx.event.ActionEvent actionEvent) {
        openDialog("Patient Home Screen", "/fxml/patientHome.fxml", new PatientHomeController());
    }

    public void openDialog(String title, String file, Object controller) {
        try {
            System.out.println("Evo me");
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            //loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene((Parent) loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception e) {
            //new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
