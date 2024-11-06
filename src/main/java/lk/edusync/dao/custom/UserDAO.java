package lk.edusync.dao.custom;

import lk.edusync.dao.SuperDAO;
import lk.edusync.entity.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO extends SuperDAO {
    public ArrayList<UserEntity> checkCredentials(String id) throws SQLException, ClassNotFoundException ;

}
