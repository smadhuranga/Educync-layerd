package lk.edusync.dao.custom;

import lk.edusync.dao.CrudDAO;
import lk.edusync.entity.StudentEntity;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<StudentEntity> {
    public ResultSet count() throws SQLException, ClassNotFoundException ;

}
