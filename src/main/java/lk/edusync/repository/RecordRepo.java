package lk.edusync.repository;

public class RecordRepo {
//    public static boolean save(Record record) throws SQLException {
//        String sql = "INSERT INTO studentAttendence (nfcNumber, time, date, Sid) VALUES (?, ?, ?, ?);";
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        pstm.setObject(1,record.getNfcNumber());
//        pstm.setObject(2,record.getTime());
//        pstm.setObject(3,record.getDate());
//        pstm.setObject(4,record.getSid());
//
//        return pstm.executeUpdate() > 0;
//
//
//    }
//
//    public static List<RecordR> getAll() throws SQLException {
//        String sql = "select a.id, s.name, s.grade, a.date, a.time, s.guardianTel, s.guardianEmail, s.guardianName from student s join studentattendence a on s.id = a.Sid";
//
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        List<RecordR> recordList = new ArrayList<>();
//        while (resultSet.next()) {
//            String id = resultSet.getString(1);
//            String name = resultSet.getString(2);
//            int grade = resultSet.getInt(3);
//            Date date = resultSet.getDate(4);
//            Time time = resultSet.getTime(5);
//            int guardianTel = resultSet.getInt(6);
//            String guardianEmail = resultSet.getString(7);
//            String guardianName = resultSet.getString(8);
//
//            RecordR record= new RecordR(id , name, grade, date, time, guardianTel, guardianEmail, guardianName);
//            recordList.add(record);
//        }
//        return recordList;
//    }
}
