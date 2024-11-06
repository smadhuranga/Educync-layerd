package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.FeeDAO;
import lk.edusync.entity.FeeEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeeDAOImpl implements FeeDAO {
    public ArrayList<FeeEntity> search(String id) throws SQLException, ClassNotFoundException {

        ArrayList<FeeEntity> fees = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM feemanagement WHERE Sid = ?",id);
        while (rst.next()) {
            FeeEntity fee = new FeeEntity(
                    rst.getString("id"),
                    rst.getString("date"),
                    rst.getString("Sid")
            );
            fees.add(fee);
        }
        return fees;
    }
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM feemanagement WHERE id = ?",id);

    }
    public boolean update(FeeEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE feemanagement SET id = ? , date = ? WHERE Sid = ?;",entity.getId(),entity.getDate(),entity.getSid());
    }
    public ArrayList<FeeEntity> getAll() throws SQLException, ClassNotFoundException {


        ArrayList<FeeEntity> fees = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT f.id ,f.date ,f.Sid ,s.name from  feemanagement f join student s on f.Sid = s.id order by f.id ASC ");
        while (rst.next()) {
            fees.add(new FeeEntity(rst.getString("id"),rst.getString("date"),rst.getString("Sid"),rst.getString("name")));
        }

        return fees;
    }

    public boolean save(FeeEntity entity) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("INSERT INTO feeManagement (id, date, Sid) VALUES(?, ?, ?)",entity.getId(),entity.getDate(),entity.getSid());

    }
}
