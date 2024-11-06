package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.RecordEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public interface RecordeViewBO extends SuperBO {
    public boolean save(Record entity) throws SQLException, ClassNotFoundException ;

    public ArrayList<RecordEntity> getAll() throws SQLException, ClassNotFoundException ;
}
