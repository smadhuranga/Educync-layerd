package lk.edusync.bo.custom;

import lk.edusync.bo.SuperBO;
import lk.edusync.entity.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    public ArrayList<UserEntity> checkCredentials(String id) throws SQLException, ClassNotFoundException ;

}
