package lk.edusync.repository;

public class FeeRepo {
//    public static List<Fee> getAll() throws SQLException {
//        String sql = "Select f.id ,f.date ,f.Sid ,s.name from  feemanagement f join student s on f.Sid = s.id order by f.id ASC ";
//
//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        List<Fee> feeList = new ArrayList<>();
//        while (resultSet.next()) {
//           String id = resultSet.getString(1);
//           String date = resultSet.getString(2);
//           String Sid = resultSet.getString(3);
//           String name = resultSet.getString(4);
//
//            Fee fee= new Fee(id , date, Sid ,name);
//            feeList.add(fee);
//        }
//        return feeList;
//    }

   /* public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM feemanagement WHERE id = ?";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }   */

}
