//package example;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet(name = "MemberServlet", value = "/member")
//public class MemberServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        MemberDAO dao = new MemberDAO();
//        List<MemberVO> list = dao.listMembers();
//
//        out.print("<html><body>");
//        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
//        out.print("<td>ID</td> <td>PW</td> <td>NAME</td> <td>EMAIL</td> <td>JOINDATE</td> </tr>");
//
//        for(int i=0; i< list.size(); i++) {
//            MemberVO memberVO = list.get(i);
//            String id = memberVO.getId();
//            String pwd = memberVO.getPwd();
//            String name = memberVO.getName();
//            String email = memberVO.getEmail();
//            Date joinDate = memberVO.getJoinDate();
//
//            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td><tr>");
//        }
//        out.print("</table></body></html>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
