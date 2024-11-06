package lk.edusync.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordTM {
    private Time time;
    private Date date;
    private String Sid;
    private String name;
    private int grade;
    private int guardianTel;
    private  String guardianEmail;
    private  String guardianName;

}
