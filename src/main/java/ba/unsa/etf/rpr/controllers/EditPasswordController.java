package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.bussines.DoctorManager;
import ba.unsa.etf.rpr.bussines.PatientManager;
import ba.unsa.etf.rpr.domain.Doctor;
import ba.unsa.etf.rpr.domain.Passwordabel;
import ba.unsa.etf.rpr.domain.Patient;
import ba.unsa.etf.rpr.exceptions.HospitalException;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Ovo radi samo jos povezivanje
 * @param <Type>
 */

public class EditPasswordController<Type extends Passwordabel> {

    private DoctorManager doctorManager = new DoctorManager();
    private PatientManager patientManager = new PatientManager();

    public TextField newPass;
    public TextField prevPass;
    private Type user;


    public EditPasswordController(Type user){
        this.user = user;
    }

    public void initialize(){
        prevPass.setText(user.getPassword());
    }

    public void save(ActionEvent actionEvent) throws HospitalException {
        user.setPassword(newPass.getText());
        if(ifDoctor()){
            doctorManager.updateDoctor((Doctor) user);
        } else if(ifPatient()) {
            patientManager.updatePatient((Patient) user);
        }

        closeWindow();
    }

    public void exit(ActionEvent actionEvent) {
        closeWindow();
    }

    private void closeWindow(){
        if(ifDoctor()){
            DoctorHomeController doctorHomeController = new DoctorHomeController((Doctor)user);
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("doctorPage"), "fxml/doctorHomePage.fxml", doctorHomeController, (Stage) newPass.getScene().getWindow());
        } else if(ifPatient()){
            PatientHomeController patientHomeController = new PatientHomeController((Patient) user);
            new OpenNewWindow<>().openDialog(AppFX.getPageTitle("patientHome"), "/fxml/patientHomePage-fxml", patientHomeController, (Stage) newPass.getScene().getWindow());
        }
    }

    private boolean ifPatient(){
        return user.getClass().getName().equals("Patient");
    }
    private boolean ifDoctor(){
        return user.getClass().getName().equals("Doctor");
    }
}

