package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.AttendenceBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.AttendenceDAO;
import lk.edusync.entity.AttendenceEntity;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendenceBOImpl implements AttendenceBO {
    AttendenceDAO attendenceDAO = (AttendenceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ATTENDENCE);


    public ArrayList<AttendenceEntity> searchNfc(String id1) throws SQLException, ClassNotFoundException {

        return attendenceDAO.searchNfc(id1);


    }

    public ArrayList<AttendenceEntity> search(String id1) throws SQLException, ClassNotFoundException {

        return attendenceDAO.search(id1);

    }

    public List<AttendenceEntity> getAll() throws SQLException, ClassNotFoundException {

        return attendenceDAO.getAll();
    }
    public  boolean update(AttendenceEntity attendence) throws SQLException, ClassNotFoundException {


        return attendenceDAO.update(attendence);

    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {

        return attendenceDAO.delete(id);
    }

    public boolean save(AttendenceEntity attendence) throws SQLException, ClassNotFoundException {

        return attendenceDAO.save(attendence);

    }
}
