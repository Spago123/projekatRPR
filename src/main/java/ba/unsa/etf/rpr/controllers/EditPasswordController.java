package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.domain.Passwordabel;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPasswordController<Type extends Passwordabel> {

    public TextField newPass;
    public TextField prevPass;
    private Type user;


    public EditPasswordController(Type user){
        this.user = user;
    }

    public void initialize(){
        System.out.println("come");
        prevPass.setText("heehhehe");

    }

    public void save(ActionEvent actionEvent) {
       // user.setPassword(newPass.getText());
        ///Update the database of the user and exit screen
        closeWindow();
    }

    public void exit(ActionEvent actionEvent) {
        closeWindow();
    }

    private void closeWindow(){
        if(user.getClass().getName().equals("Doctor")){
            DoctorHomeController doctorHomeController = new DoctorHomeController();
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("doctorPage"), "fxml/doctorHomePage.fxml", doctorHomeController, (Stage) newPass.getScene().getWindow());
        } else {
            PatientHomeController patientHomeController = new PatientHomeController();
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("patientHome"), "/fxml/patientHomePage-fxml", patientHomeController, (Stage) newPass.getScene().getWindow());
        }
    }
}
