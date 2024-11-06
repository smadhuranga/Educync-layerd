package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.RecordViewDAO;
import lk.edusync.entity.RecordEntity;


import java.sql.*;
import java.util.ArrayList;

public class RecordViewDAOImpl implements RecordViewDAO {
    public boolean save(RecordEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO studentAttendence (nfcNumber, time, date, Sid) VALUES (?, ?, ?, ?);",entity.getNfcNumber(),entity.getTime(),entity.getDate(),entity.getSid());


    }

    @Override
    public boolean save(Record record) throws SQLException, ClassNotFoundException {
        return false;
    }

    public ArrayList<RecordEntity> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<RecordEntity> records = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT a.id, s.name, s.grade, a.date, a.time, s.guardianTel, s.guardianEmail, s.guardianName from student s join studentattendence a on s.id = a.Sid");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            int grade = resultSet.getInt(3);
            Date date = resultSet.getDate(4);
            Time time = resultSet.getTime(5);
            int guardianTel = resultSet.getInt(6);
            String guardianEmail = resultSet.getString(7);
            String guardianName = resultSet.getString(8);

            RecordEntity record= new RecordEntity(id , name, grade, date, time, guardianTel, guardianEmail, guardianName);
            records.add(record);
        }
        return records;
    }
}
