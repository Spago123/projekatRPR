package ba.unsa.etf.rpr.domain;


import java.util.Date;
import java.util.Objects;

/**
 * Patient Java Bean
 */
public class Patient {
    private int id;
    private String name;
    private long UIN;
    private Doctor doctor;

    public Patient(int id, String name, long UIN, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.UIN = UIN;
        this.doctor = doctor;
    }

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUIN() {
        return UIN;
    }

    public void setUIN(long UIN) {
        this.UIN = UIN;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", UIN=" + UIN +
                ", doctor=" + doctor +
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
        Patient patient = (Patient) o;
        return id == patient.id && UIN == patient.UIN && Objects.equals(name, patient.name) && Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, UIN, doctor);
    }
}
