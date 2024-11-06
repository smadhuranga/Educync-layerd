package lk.edusync.dao.custom;

import lk.edusync.dao.SuperDAO;
import lk.edusync.entity.RecordEntity;


import java.sql.*;
import java.util.ArrayList;

public interface RecordViewDAO extends SuperDAO {
    public boolean save(Record record) throws SQLException, ClassNotFoundException;

    public ArrayList<RecordEntity> getAll() throws SQLException, ClassNotFoundException;
}
