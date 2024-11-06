package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.QueryDAO;
import lk.edusync.entity.RecordEntity;
import lk.edusync.entity.ScheduleEntity;


import java.sql.*;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    public ArrayList<ScheduleEntity> search(String id) throws SQLException, ClassNotFoundException {

        ArrayList<ScheduleEntity> schedules = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT s.id, s.date, s.time, e.Cid, e.Eid FROM schedule s JOIN scheduleclassdetails sch ON s.id = sch.Shid JOIN class c ON sch.Clid = c.id JOIN employeedetails e ON c.id = e.Cid where s.id = ?",id);

        while (resultSet.next()) {
            ScheduleEntity schedule = new ScheduleEntity(
                    resultSet.getString("id"),
                resultSet.getString("date"),
                resultSet.getString("time"),
                 resultSet.getString("Cid"),
                resultSet.getString("Eid")
            );
            schedules.add(schedule);
        }
        return schedules;


    }
    public ArrayList<ScheduleEntity> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<ScheduleEntity> schedules = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT s.id as shid, s.date, s.time, c.id as calid, st.id as sid, st.name FROM schedule s JOIN scheduleclassdetails sch ON s.id = sch.Shid JOIN class c ON sch.Clid = c.id JOIN studetclassdetails stu ON c.id = stu.Clid JOIN student st ON stu.Stid = st.id");
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            Date date = resultSet.getDate(2);
            Time time = resultSet.getTime(3);
            String cid = resultSet.getString(4);
            String sid = resultSet.getString(5);
            String name = resultSet.getString(6);

            ScheduleEntity schedule = new ScheduleEntity(id , date, time, cid, sid, name);
            schedules.add(schedule);
        }
        return schedules;
    }
    public ArrayList<RecordEntity> save (String nfcNum) throws SQLException, ClassNotFoundException {

        ArrayList<RecordEntity> records = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT a.id, a.nfcNumber, a.time, a.date, a.Sid, s.guardianEmail, s.name from student s join studentattendence a on s.id = a.Sid where nfcNumber = ?",nfcNum);
        while (resultSet.next()) {
            RecordEntity record = new RecordEntity(
                    resultSet.getString("Sid"),
                    resultSet.getString("guardianEmail"),
                    resultSet.getString("name")
            );
            records.add(record);

        }

        return records;
    }

}
