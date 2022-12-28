package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final PatientDao patientDao = new PatientDaoSQLImpl();
    private static final DoctorDao doctorDao = new DoctorDaoSQLImpl();
    private static final HistoryDao historyDao = new HistoryDaoSQLImpl();
    private static final DepartmentDao departmentDao = new DepartmentDaoSQLImpl();

    private DaoFactory(){

    }

    public static PatientDao patientDao(){
        return patientDao;
    }

    public static DoctorDao doctorDao(){
        return doctorDao;
    }

    public static HistoryDao historyDao(){
        return historyDao;
    }

    public static DepartmentDao departmentDao(){
        return departmentDao;
    }
}
