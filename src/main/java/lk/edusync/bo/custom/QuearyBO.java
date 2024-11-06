package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.RecordEntity;
import lk.edusync.entity.ScheduleEntity;


import java.sql.SQLException;
import java.util.ArrayList;

public interface QuearyBO extends SuperBO {
    public ArrayList<ScheduleEntity> search(String id) throws SQLException, ClassNotFoundException ;
    public ArrayList<ScheduleEntity> getAll() throws SQLException, ClassNotFoundException ;
    public ArrayList<RecordEntity> save (String nfcNum) throws SQLException, ClassNotFoundException ;
}
