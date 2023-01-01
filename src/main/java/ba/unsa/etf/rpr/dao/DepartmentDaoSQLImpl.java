package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Department;
import ba.unsa.etf.rpr.exceptions.HospitalException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DepartmentDaoSQLImpl extends AbstractDao<Department> implements DepartmentDao{
    public DepartmentDaoSQLImpl() {
        super("Departments");
    }

    @Override
    public Department row2object(ResultSet rs) throws HospitalException {
        try{
            return new Department(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            throw new HospitalException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Department object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }
}
