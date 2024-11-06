package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.StudentBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.StudentDAO;
import lk.edusync.entity.StudentEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

    public boolean save(StudentEntity entity) throws SQLException, ClassNotFoundException {
            return studentDAO.save(entity);

    }

    public ArrayList<StudentEntity> search(String id) throws SQLException, ClassNotFoundException {
            return studentDAO.search(id);

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
            return studentDAO.delete(id);
    }

    public ArrayList<StudentEntity> getAll() throws SQLException, ClassNotFoundException {
        return studentDAO.getAll();
    }

    public boolean update(StudentEntity entity) throws SQLException, ClassNotFoundException {
        return studentDAO.update(entity);

    }

    public ResultSet count() throws SQLException, ClassNotFoundException {
        return studentDAO.count();
    }

}
