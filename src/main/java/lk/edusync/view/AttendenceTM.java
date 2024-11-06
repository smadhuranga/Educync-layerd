package lk.edusync.view;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendenceTM {
    private int id;
    private String nfcNumber;
    private String time;
    private String date;
    private String Sid;


}
