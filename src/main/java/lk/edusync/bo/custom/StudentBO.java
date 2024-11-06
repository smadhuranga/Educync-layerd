package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.StudentEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public boolean save(StudentEntity entity) throws SQLException, ClassNotFoundException ;

    public ArrayList<StudentEntity> search(String id) throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public ArrayList<StudentEntity> getAll() throws SQLException, ClassNotFoundException ;

    public boolean update(StudentEntity entity) throws SQLException, ClassNotFoundException ;

    public ResultSet count() throws SQLException, ClassNotFoundException ;

}
