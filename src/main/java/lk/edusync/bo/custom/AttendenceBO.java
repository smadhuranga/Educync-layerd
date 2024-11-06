package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.AttendenceEntity;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AttendenceBO extends SuperBO {
    public ArrayList<AttendenceEntity> searchNfc(String id1) throws SQLException, ClassNotFoundException;

    public ArrayList<AttendenceEntity> search(String id1) throws SQLException, ClassNotFoundException;

    public List<AttendenceEntity> getAll() throws SQLException, ClassNotFoundException;
    public  boolean update(AttendenceEntity attendence) throws SQLException, ClassNotFoundException;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException;

    public boolean save(AttendenceEntity attendence) throws SQLException, ClassNotFoundException;
}
