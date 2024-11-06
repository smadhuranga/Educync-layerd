package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.EmployeeBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.EmployeeDAO;
import lk.edusync.entity.EmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EMPLOYEE);



    public ArrayList<EmployeeEntity> search(String searchText) throws SQLException, ClassNotFoundException {

        return employeeDAO.search(searchText);

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    public boolean update(EmployeeEntity employee) throws SQLException, ClassNotFoundException {

        return employeeDAO.update(employee);
    }

    public ArrayList<EmployeeEntity> getAll() throws SQLException, ClassNotFoundException {

        return employeeDAO.getAll();
    }

    public boolean save(EmployeeEntity employee) throws SQLException, ClassNotFoundException {


        return employeeDAO.save(employee);
    }
}
