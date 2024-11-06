package lk.edusync.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AttendenceEntity {
    private int id;
    private String nfcNumber;
    private String time;
    private String date;
    private String Sid;

    public AttendenceEntity(String nfcNumber, String time, String date, String sid) {
        this.time = time;
        this.nfcNumber = nfcNumber;
        this.date = date;
        this.Sid = sid;
    }
}

