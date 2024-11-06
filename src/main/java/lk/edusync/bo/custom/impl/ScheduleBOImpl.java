package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.ScheduleBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.ScheduleDAO;
import lk.edusync.entity.ScheduleEntity;

import java.sql.SQLException;

public class ScheduleBOImpl implements ScheduleBO {
    ScheduleDAO scheduleDAO = (ScheduleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.SCHEDULE);

    public boolean update(ScheduleEntity entity) throws SQLException, ClassNotFoundException {
        return scheduleDAO.update(entity);
    }
    public boolean save(ScheduleEntity entity) throws SQLException, ClassNotFoundException {
                return scheduleDAO.save(entity);
    }
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
            return scheduleDAO.delete(id);
    }
}
