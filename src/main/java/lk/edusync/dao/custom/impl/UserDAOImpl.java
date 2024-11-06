package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.UserDAO;
import lk.edusync.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    public ArrayList<UserEntity> checkCredentials(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT id, password FROM user WHERE id =?",id);
        ArrayList<UserEntity> users = new ArrayList<>();

        while (rs.next()) {
            UserEntity user = new UserEntity(
                    rs.getString("id"),
                    rs.getString("password")
            );
            users.add(user);

        }
        return users;


    }
}
