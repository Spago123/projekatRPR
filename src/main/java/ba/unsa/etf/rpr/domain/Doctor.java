package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Doctor Java Bean
 */

public class Doctor {
    private int id;
    private String name;
    private Date startedWork;
    private Department department;

    public Doctor(){

    }
    public Doctor(int id, String name, Date startedWork, Department department) {
        this.id = id;
        this.name = name;
        this.startedWork = startedWork;
        this.department = department;
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

    public Date getStartedWork() {
        return startedWork;
    }

    public void setStartedWork(Date startedWork) {
        this.startedWork = startedWork;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startedWork=" + startedWork +
                ", department=" + department +
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
        Doctor doctor = (Doctor) o;
        return id == doctor.id && name.equals(doctor.name) && Objects.equals(startedWork, doctor.startedWork) && department.equals(doctor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startedWork, department);
    }
}
