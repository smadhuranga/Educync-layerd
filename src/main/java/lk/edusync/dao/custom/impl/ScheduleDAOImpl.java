package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.ScheduleDAO;
import lk.edusync.entity.ScheduleEntity;


import java.sql.SQLException;

public class ScheduleDAOImpl implements ScheduleDAO {

    public boolean update(ScheduleEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE schedule SET date = ?, time = ? WHERE id = ?;",entity.getDate(),entity.getTime(),entity.getShid());

    }
    public boolean save(ScheduleEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO schedule (id, date, time) VALUES(?, ?, ?)",entity.getShid(),entity.getDate(),entity.getTime());

    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM schedule WHERE id = ?;",id);
    }

}
