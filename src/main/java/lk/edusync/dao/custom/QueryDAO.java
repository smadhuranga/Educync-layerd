package lk.edusync.dao.custom;

import lk.edusync.dao.SuperDAO;
import lk.edusync.entity.RecordEntity;
import lk.edusync.entity.ScheduleEntity;


import java.sql.*;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<ScheduleEntity> search(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<ScheduleEntity> getAll() throws SQLException, ClassNotFoundException;
    public ArrayList<RecordEntity> save (String nfcNum) throws SQLException, ClassNotFoundException;

}
