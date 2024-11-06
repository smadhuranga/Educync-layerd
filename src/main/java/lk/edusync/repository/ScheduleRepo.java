package lk.edusync.repository;

public class ScheduleRepo {
//    public static boolean delete(String id) throws SQLException {
//        String sql = "DELETE FROM schedule WHERE id = ?;";
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        pstm.setObject(1, id);
//
//        return pstm.executeUpdate() > 0;
//    }

//   public static List<Schedule> getAll() throws SQLException {
//        String sql = "SELECT s.id as shid, s.date, s.time, c.id as calid, st.id as sid, st.name FROM schedule s JOIN scheduleclassdetails sch ON s.id = sch.Shid JOIN class c ON sch.Clid = c.id JOIN studetclassdetails stu ON c.id = stu.Clid JOIN student st ON stu.Stid = st.id";
//
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        List<Schedule> scheduleList = new ArrayList<>();
//        while (resultSet.next()) {
//            String id = resultSet.getString(1);
//            Date date = resultSet.getDate(2);
//            Time time = resultSet.getTime(3);
//            String cid = resultSet.getString(4);
//            String sid = resultSet.getString(5);
//            String name = resultSet.getString(6);
//
//            Schedule schedule = new Schedule(id , date, time, cid, sid, name);
//            scheduleList.add(schedule);
//        }
//        return scheduleList;
//    }
}
