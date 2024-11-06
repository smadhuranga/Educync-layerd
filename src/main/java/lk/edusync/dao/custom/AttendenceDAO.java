package lk.edusync.dao.custom;

import lk.edusync.dao.CrudDAO;
import lk.edusync.entity.AttendenceEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendenceDAO extends CrudDAO<AttendenceEntity> {
    public ArrayList<AttendenceEntity> searchNfc(String id1) throws SQLException, ClassNotFoundException;


}
