//package lk.edusync.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Date;
//import java.sql.Time;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Schedule {
//    private String shid;
//    private Date date;
//    private Time time;
//    private String calid;
//    private String sid;
//    private String name;
//    private String Eid;
//
//
//    public Schedule(String id, String date, String time, String cid, String eid) {
//        this.shid = id;
//        this.date = Date.valueOf(date);
//        this.time = Time.valueOf(time);
//        this.calid = cid;
//        this.Eid = eid;
//
//    }
//
//    public Schedule(String id, Date date, Time time, String cid, String sid, String name) {
//        this.shid = id;
//        this.date = date;
//        this.time = time;
//        this.calid = cid;
//        this.sid = sid;
//        this.name = name;
//        this.Eid = id;
//
//    }
//
//    public Schedule(String id, String date, String time) {
//        this.shid = id;
//        this.date = Date.valueOf(date);
//        this.time = Time.valueOf(time);
//    }
//}
