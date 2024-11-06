package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.EmployeeEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    public ArrayList<EmployeeEntity> search(String searchText) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public boolean update(EmployeeEntity employee) throws SQLException, ClassNotFoundException;

    public ArrayList<EmployeeEntity> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(EmployeeEntity employee) throws SQLException, ClassNotFoundException;
}
