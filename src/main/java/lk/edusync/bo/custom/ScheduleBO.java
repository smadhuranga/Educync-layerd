package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.ScheduleEntity;

import java.sql.SQLException;

public interface ScheduleBO extends SuperBO {
    public boolean update(ScheduleEntity entity) throws SQLException, ClassNotFoundException ;
    public boolean save(ScheduleEntity entity) throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;
}
