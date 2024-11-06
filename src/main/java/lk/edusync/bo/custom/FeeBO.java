package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.FeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FeeBO extends SuperBO {
    public ArrayList<FeeEntity> search(String id) throws SQLException, ClassNotFoundException ;
    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
    public boolean update(FeeEntity entity) throws SQLException, ClassNotFoundException ;
    public ArrayList<FeeEntity> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(FeeEntity entity) throws SQLException, ClassNotFoundException ;
}
