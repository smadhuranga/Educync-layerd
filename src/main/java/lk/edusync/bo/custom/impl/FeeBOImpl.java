package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.FeeBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.custom.FeeDAO;
import lk.edusync.entity.FeeEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public class FeeBOImpl implements FeeBO {
    FeeDAO feeDAO = (FeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.FEE);
    public ArrayList<FeeEntity> search(String id) throws SQLException, ClassNotFoundException {

        return  feeDAO.search(id);

    }
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return feeDAO.delete(id);
    }
    public boolean update(FeeEntity entity) throws SQLException, ClassNotFoundException {

        return feeDAO.update(entity);
    }
    public ArrayList<FeeEntity> getAll() throws SQLException, ClassNotFoundException {
        return  feeDAO.getAll();
    }

    public boolean save(FeeEntity entity) throws SQLException, ClassNotFoundException {
        return feeDAO.save(entity);
    }
}


