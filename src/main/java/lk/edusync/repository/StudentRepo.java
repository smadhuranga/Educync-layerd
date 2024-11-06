package lk.edusync.repository;

public class StudentRepo {
//
//    public static boolean delete(String id) throws SQLException {
//        String sql = "DELETE FROM student WHERE id = ?";
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        pstm.setObject(1, id);
//
//        return pstm.executeUpdate() > 0;
//    }
//
//    public static List<Student> getAll() throws SQLException {
//        String sql = "SELECT * FROM student";
//
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        List<Student> studentsList = new ArrayList<>();
//        while (resultSet.next()) {
//            String id = resultSet.getString(1);
//            String name = resultSet.getString(2);
//            int grade = resultSet.getInt(3);
//            String address = resultSet.getString(4);
//            String gname = resultSet.getString(5);
//            String gadrress = resultSet.getString(6);
//            String gemail = resultSet.getString(7);
//            String gtel = String.valueOf(resultSet.getInt(8));
//
//            Student student = new Student(id , name , grade , address , gname , gadrress , gemail , gtel);
//            studentsList.add(student);
//        }
//        return studentsList;
//    }
//
//    public static boolean update(Student student) throws SQLException {
//        String sql = "UPDATE student SET name = ?, grade = ?, address = ?, guardianName = ?, guardianAddress =?, guardianEmail =? , guardianTel =? WHERE id = ?";
//        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
//        pstm.setObject(1, student.getName());
//        pstm.setObject(2,student.getGrade());
//        pstm.setObject(3,student.getAddress());
//        pstm.setObject(4,student.getGuardianName());
//        pstm.setObject(5,student.getGuardianAddress());
//        pstm.setObject(6,student.getGuardianEmail());
//        pstm.setObject(7,student.getGuardianTel());
//        pstm.setObject(8,student.getId());
//        return pstm.executeUpdate() > 0;
//
//    }
}
