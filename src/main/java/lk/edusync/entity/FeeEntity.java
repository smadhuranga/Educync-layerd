package lk.edusync.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeeEntity {
    private String id;
    private String name;
    private String date;
    private String Sid;


    public FeeEntity(String id, String date, String sid) {
        this.id = id;
        this.date = date;
        this.Sid = sid;
    }
}
