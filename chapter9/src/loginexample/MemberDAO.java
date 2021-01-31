package loginexample;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private PreparedStatement pstmt;
    private Connection con;
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

    public boolean isExisted(MemberVO memberVO) {
        boolean result = false;
        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        try{
            con = dataFactory.getConnection();
            String query = "select decode(count(*), 1, 'true', 'false') as result from t_member";
            query += " where id=? and pwd=?";
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery(query);
            System.out.println(rs);
            rs.next();
            result = Boolean.parseBoolean(rs.getString("result"));
            System.out.println("result=" + result);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<MemberVO>();
        try {
//            connDB();
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            System.out.println("prepared statement : " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addMember(MemberVO memberVO) {
        try{
            con = dataFactory.getConnection();
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();

            String query = "insert into t_member";
            query += "(id, pwd, name, email)";
            query += " values(?, ?, ?, ?)";

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            System.out.println("preparedStatement222 : " + query);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delMember(String id) {
        try{
            con = dataFactory.getConnection();

            String query = "delete from t_member" + " where id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            System.out.println(pstmt);
            pstmt.executeUpdate();
            pstmt.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
