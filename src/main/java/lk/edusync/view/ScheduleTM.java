package lk.edusync.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleTM {
    private String shid;
    private Date date;
    private Time time;
    private String calid;
    private String sid;
    private String name;
}
