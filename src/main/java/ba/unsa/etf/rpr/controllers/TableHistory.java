package ba.unsa.etf.rpr.controllers;


import javafx.scene.control.Button;

public class TableHistory {
    private Integer id;
    private String doctor;
    private String diagnosis;
    private Button button;

    public TableHistory(Integer id, String doctor, String diagnosis, Button button) {
        this.id = id;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.button = button;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
