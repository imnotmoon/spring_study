//package example;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class MemberDAO {
//    private Statement stmt;
//    private PreparedStatement pstmt;
//    private Connection con;
//    private String driver = "com.mysql.jdbc.Driver";
//    private String url = "jdbc:mysql://localhost:3306/DatabaseServlet?serverTimezone=UTC";
//    private String user = "root";
//    private String password = "maupas";
//
//    public List<MemberVO> listMembers() {
//        List<MemberVO> list = new ArrayList<MemberVO>();
//        try {
//            connDB();
//            String query = "select * from t_member";
//            System.out.println("prepared statement : " + query);
//            pstmt = con.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//
////            System.out.println(query);
////            ResultSet rs = stmt.executeQuery(query);
//            while(rs.next()) {
//                String id = rs.getString("id");
//                String pwd = rs.getString("pwd");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                Date joinDate = rs.getDate("joinDate");
//
//                MemberVO vo = new MemberVO();
//                vo.setId(id);
//                vo.setPwd(pwd);
//                vo.setName(name);
//                vo.setEmail(email);
//                vo.setJoinDate(joinDate);
//                list.add(vo);
//            }
//            rs.close();
//            stmt.close();
//            con.close();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    private void connDB() {
//        try {
//            Class.forName(driver);
//            System.out.println("Oracle driver loading succeed");
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection genererated Succeed");
//            stmt = con.createStatement();
//            System.out.println("Statement generated Succeed");
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
