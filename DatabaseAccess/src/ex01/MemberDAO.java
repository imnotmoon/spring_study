package ex01;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private PreparedStatement pstmt;
    private Connection con;
//    private String driver = "com.mysql.jdbc.Driver";
//    private String url = "jdbc:mysql://localhost:3306/DatabaseServlet?serverTimezone=UTC";
//    private String user = "root";
//    private String password = "maupas";

//    private Connection con;
//    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/mysql");     // context.xml > resource > name
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ex02.MemberVO> listMembers() {
        List<ex02.MemberVO> list = new ArrayList<ex02.MemberVO>();
        try {
//            connDB();
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            System.out.println("prepared statement : " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                ex02.MemberVO vo = new ex02.MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

//   Comment out b/o use of Connection Pool

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

    public void addMember(ex02.MemberVO memberVO) {
        try{
            con = dataFactory.getConnection();
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();

            String query = "insert into t_member";
            query += "(id, pwd, name, email)";
            query += " values(?, ?, ?, ?)";
            System.out.println("preparedStatement : " + query);
            pstmt = con.prepareStatement(query);
            pstmt.executeQuery();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delMember(String id) {

    }
}
