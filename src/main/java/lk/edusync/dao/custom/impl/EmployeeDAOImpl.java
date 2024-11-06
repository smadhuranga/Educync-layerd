package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.EmployeeDAO;
import lk.edusync.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

public ArrayList<EmployeeEntity> search(String id) throws SQLException, ClassNotFoundException {

    ArrayList<EmployeeEntity> employees = new ArrayList<>();
    ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE id = ?",id);
    while (rst.next()) {

        employees.add(new EmployeeEntity(rst.getString("id"),
                rst.getString("name"),
                rst.getString("address"),
                rst.getString("email"),
                rst.getString("roll"),
                rst.getString("nic"),
                rst.getInt("tel")));
    }
    return employees;

    }

public boolean delete(String id) throws SQLException, ClassNotFoundException {

    return SQLUtil.execute("DELETE FROM employee WHERE id = ?;",id);
}

public boolean update(EmployeeEntity entity) throws SQLException, ClassNotFoundException {

    return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, email = ?, roll = ?, nic =?, tel =?  WHERE id = ?",entity.getName(),entity.getAddress(),entity.getEmail(),entity.getRoll(),
            entity.getNic(),entity.getTel(),entity.getId());

}

public ArrayList<EmployeeEntity> getAll() throws SQLException, ClassNotFoundException {

    ArrayList<EmployeeEntity> employees = new ArrayList<>();
    ResultSet rst = SQLUtil.execute("SELECT * FROM employee");
    while (rst.next()) {
        employees.add(new EmployeeEntity(rst.getString("id"),rst.getString("name"),
                rst.getString("address"),rst.getString("email"),rst.getString("roll"),rst.getString("nic"),
                rst.getInt("tel")));
    }
    return employees;
}

public boolean save(EmployeeEntity entity) throws SQLException, ClassNotFoundException {


    return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getEmail(),
            entity.getRoll(),entity.getNic(),entity.getTel());
}

}
