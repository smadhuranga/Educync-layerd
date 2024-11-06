package lk.edusync.dao.custom.impl;

import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.AttendenceDAO;
import lk.edusync.entity.AttendenceEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendenceDAOImpl implements AttendenceDAO {


    public ArrayList<AttendenceEntity> searchNfc(String id1) throws SQLException, ClassNotFoundException {

        ArrayList<AttendenceEntity> attendences = new ArrayList<>();
        ResultSet rst = SQLUtil.execute( "SELECT sc.id ,sc.nfcNumber,sc.time,sc.date,sc.Sid,st.name FROM studentattendence sc join student st on sc.Sid = st.id where sc.nfcNumber = ?;",id1);
        while (rst.next()) {
            attendences.add(new AttendenceEntity(rst.getString("nfcNumber"),rst.getString("time"),rst.getString("date"),rst.getString("Sid")));
        }
        return attendences;


    }

    public ArrayList<AttendenceEntity> search(String id1) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT nfcNumber,time,date,Sid FROM studentattendence where Sid = ?",id1);

        ArrayList<AttendenceEntity> attendences = new ArrayList<>();
        while (rst.next()){
            attendences.add(new AttendenceEntity(rst.getString("nfcNumber"),rst.getString("time"),rst.getString("date"),rst.getString("Sid")));
        }
        return attendences;


    }

    public  ArrayList<AttendenceEntity> getAll() throws SQLException, ClassNotFoundException {


        ArrayList<AttendenceEntity> attendences = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT sc.id ,sc.nfcNumber,sc.time,sc.date,sc.Sid,st.name FROM studentattendence sc join student st on sc.Sid = st.id");
        while (rst.next()){
            attendences.add(new AttendenceEntity(rst.getInt("id"),rst.getString("nfcNumber"),rst.getString("time"),rst.getString("date"),rst.getString("Sid")));
        }
        return attendences;
    }
    public  boolean update(AttendenceEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE studentattendence SET nfcNumber = ?,  time = ?, date = ? WHERE Sid = ?",entity.getNfcNumber(),entity.getTime(),entity.getDate(),entity.getSid());

    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("DELETE FROM studentattendence WHERE Sid = ?",id);
    }

    public boolean save(AttendenceEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("NSERT INTO studentAttendence (nfcNumber, time, date, Sid) VALUES (?, ?, ?, ?);",entity.getNfcNumber(),entity.getTime(),entity.getDate(),entity.getSid());

    }
}
