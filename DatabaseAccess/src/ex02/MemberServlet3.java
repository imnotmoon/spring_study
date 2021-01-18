package ex02;

import ex01.MemberDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MemberServlet3", value = "/member3")
public class MemberServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        ex02.MemberDAO dao = new ex02.MemberDAO();
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");

        if(command != null && command.equals("addMember")) {
            String _id = request.getParameter("id");
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");

            ex02.MemberVO vo = new ex02.MemberVO();
            vo.setId(_id);
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);
            dao.addMember(vo);
        } else if(command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }

        List<ex02.MemberVO> list = dao.listMembers();
        out.print("<html><body>");
        out.print("<table border=1> <tr align='center' bgcolor='lightgreen'>");
        out.print("<td>ID</td><td>PW</td><td>NAME</td><td>EMAIL</td><td>JOINDATE</td> <td>DELETE</td></tr>");

        for(int i=0; i<list.size(); i++) {
            MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();

            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email +
                    "</td><td>" + joinDate + "</td><td>" + "<a href='/DatabaseAccess_war_exploded/member3?command=delMember&id=" + id +
                    "'> DELETE </a></td></tr>");
        }
        out.print("</table></body></html>");
        out.print("<a href='memberForm.html'> SIGN UP NEW USER");
    }
}
