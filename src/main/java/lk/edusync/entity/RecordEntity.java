package lk.edusync.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordEntity {
    private String Sid;
    private String name;





    private int grade;
    private Date date;
    private Time time;
    private int guardianTel;
    private  String guardianEmail;
    private  String guardianName;
    private String nfcNum;

    public RecordEntity(String nfcNum, Time time, Date date, String Sid, String email, String name) {
        this.Sid = Sid;
        this.time = time;
        this.date = date;
        this.guardianEmail = email;
        this.name = name;
        this.nfcNum = nfcNum;



    }

    public RecordEntity(String id, String name, int grade, Date date, Time time, int guardianTel, String guardianEmail, String guardianName) {
        this.Sid = id;
        this.name = name;
        this.grade = grade;
        this.date = date;
        this.time = time;
        this.guardianTel = guardianTel;
        this.guardianEmail = guardianEmail;
        this.guardianName = guardianName;

    }



    public RecordEntity(String sid, String guardianEmail, String name, String sid1) {
        this.Sid = sid;
        this.guardianEmail = guardianEmail;
        this.name = name;
        this.guardianName = name;
    }

    public RecordEntity(String sid, String guardianEmail, String name) {
        this.Sid = sid;
        this.guardianEmail = guardianEmail;
        this.name = name;
    }

    public RecordEntity(String nfcNum, Time time, Date date, String sid) {
        this.nfcNum = nfcNum;
        this.time = time;
        this.date = date;
        this.Sid = sid;
    }

    public String getSid() {
        return Sid;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getGuardianTel() {
        return guardianTel;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getNfcNum() {
        return nfcNum;
    }

    public Object getNfcNumber() {
        return nfcNum;
    }
}
