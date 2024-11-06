package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.QuearyBO;
import lk.edusync.dao.custom.QueryDAO;
import lk.edusync.dao.custom.impl.QueryDAOImpl;
import lk.edusync.entity.RecordEntity;
import lk.edusync.entity.ScheduleEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QuearyBO {
    QueryDAO queryDAO = new QueryDAOImpl();

    public ArrayList<ScheduleEntity> search(String id) throws SQLException, ClassNotFoundException {

        return queryDAO.search(id);

    }
    public ArrayList<ScheduleEntity> getAll() throws SQLException, ClassNotFoundException {
        return queryDAO.getAll();
    }
    public ArrayList<RecordEntity> save (String nfcNum) throws SQLException, ClassNotFoundException {
        return queryDAO.save(nfcNum);

    }
}
