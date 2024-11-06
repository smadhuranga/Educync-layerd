package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.RecordeViewBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.RecordViewDAO;
import lk.edusync.entity.RecordEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public class RecordViewBOImpl implements RecordeViewBO {
    RecordViewDAO recordViewDAO = (RecordViewDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.RECORDVIEW);

    public boolean save(Record entity) throws SQLException, ClassNotFoundException {
        return recordViewDAO.save(entity);
    }

    public ArrayList<RecordEntity> getAll() throws SQLException, ClassNotFoundException {
        return recordViewDAO.getAll();
    }

}
