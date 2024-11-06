package lk.edusync.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendenceDTO {
    private int id;
    private String nfcNumber;
    private String time;
    private String date;
    private String Sid;


}
