package lk.edusync.bo.custom.impl;

import lk.edusync.bo.custom.UserBO;
import lk.edusync.dao.DAOFactory;
import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.StudentDAO;
import lk.edusync.dao.custom.UserDAO;
import lk.edusync.dao.custom.impl.UserDAOImpl;
import lk.edusync.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {
    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);

    public ArrayList<UserEntity> checkCredentials(String id) throws SQLException, ClassNotFoundException {
        return userDAO.checkCredentials(id);

    }

}
