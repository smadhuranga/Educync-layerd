package lk.edusync.view;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class StudentTM {
    private String id;
    private String name;
    private String grade;
    private String address;
    private  String guardianName;
    private String guardianAddress;
    private String guardianEmail;
    private  String guardianTel;


}
