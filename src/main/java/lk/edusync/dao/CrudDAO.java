package lk.edusync.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    public ArrayList<T> search(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public  boolean update(T dto) throws SQLException, ClassNotFoundException;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException;

    public boolean save(T dto) throws SQLException, ClassNotFoundException;
}
