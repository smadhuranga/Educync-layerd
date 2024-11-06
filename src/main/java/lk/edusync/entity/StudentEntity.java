package lk.edusync.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class StudentEntity { // this model class represent real world Student entity
    private String id;
    private String name;
    private int grade;
    private String address;
    private String guardianName;
    private String guardianAddress;
    private String guardianEmail;
    private String guardianTel;


    public StudentEntity(String id, String name, int address, String guardianName, String guardianAddress, String guardianEmail, int guardianTel) {
    }

    public StudentEntity(String grade, String studentCount) {

    }
}
