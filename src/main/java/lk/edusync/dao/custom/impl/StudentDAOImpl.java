package lk.edusync.dao.custom.impl;


import lk.edusync.dao.SQLUtil;
import lk.edusync.dao.custom.StudentDAO;
import lk.edusync.entity.StudentEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    public boolean save(StudentEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getGrade(),entity.getAddress(),
                entity.getGuardianName(),entity.getGuardianAddress(),entity.getGuardianEmail(),entity.getGuardianTel());

    }

    public ArrayList<StudentEntity> search(String id) throws SQLException, ClassNotFoundException {

        ArrayList<StudentEntity> students = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM student WHERE id = ?",id);
        while (resultSet.next()) {
            StudentEntity student = new StudentEntity(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("grade"),
                    resultSet.getString("address"),
                    resultSet.getString("guardianName"),
                    resultSet.getString("guardianAddress"),
                    resultSet.getString("guardianEmail"),
                    resultSet.getString("guardianTel")
            );
            students.add(student);
        }
        return students;

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("DELETE FROM student WHERE id = ?",id);
    }

    public ArrayList<StudentEntity> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<StudentEntity> students = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM student;");
        while (resultSet.next()) {
            students.add(new StudentEntity(resultSet.getString("id"),resultSet.getString("name"),resultSet.getInt("grade"),resultSet.getString("address"),resultSet.getString("guardianName"),resultSet.getString("guardianAddress"),resultSet.getString("guardianEmail"),resultSet.getString("guardianTel")));

        }
        return students;
    }

    public boolean update(StudentEntity entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE student SET name = ?, grade = ?, address = ?, guardianName = ?, guardianAddress =?, guardianEmail =? , guardianTel =? WHERE id = ?",
                entity.getName(),entity.getGrade(),entity.getAddress(),entity.getGuardianName(),entity.getGuardianAddress(),
                entity.getGuardianEmail(),entity.getGuardianTel(),entity.getId());

    }

    public ResultSet count() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT grade AS Grade, COUNT(*) AS StudentCount FROM student GROUP BY grade ORDER BY Grade;");

        return resultSet;
    }
}
