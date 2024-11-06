package lk.edusync.dao.custom;

import lk.edusync.dao.SuperDAO;
import lk.edusync.entity.ScheduleEntity;


import java.sql.SQLException;

public interface ScheduleDAO extends SuperDAO  {

    public boolean update(ScheduleEntity schedule) throws SQLException, ClassNotFoundException;

    public boolean save(ScheduleEntity schedule) throws SQLException, ClassNotFoundException;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException;
}
