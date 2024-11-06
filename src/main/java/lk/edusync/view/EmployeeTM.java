package lk.edusync.view;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeTM {
    private String id;
    private String name;
    private String address;
    private String email;
    private String roll;
    private String nic;
    private int tel;
}
