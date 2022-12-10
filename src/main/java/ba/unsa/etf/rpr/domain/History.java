package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * History Java Bean
 */

public class History {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private Date date;

    public History(int id, Patient patient, Doctor doctor, String diagnosis, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", diagnosis='" + diagnosis + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return id == history.id && patient.equals(history.patient) && doctor.equals(history.doctor) && diagnosis.equals(history.diagnosis) && date.equals(history.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, diagnosis, date);
    }
}
