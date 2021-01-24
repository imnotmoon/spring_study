package userInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViewServlet", value = "/viewMembers")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        List memberList = (List) request.getAttribute("membersList");

        out.print("<html><body>");
        out.print("<table border=1> <tr align='center' bgcolor='lightgreen'>");
        out.print("<td>ID</td> <td>NAME</td> <td>EMAIL</td> <td>JOINDATE</td>  <td>DELETE</td></tr>");

        for(int i=0; i<memberList.size(); i++) {
            MemberVO vo = (MemberVO) memberList.get(i);
            out.print("<tr><td>" + vo.getId() + "</td>");
            out.print("<td>" + vo.getName() + "</td>");
            out.print("<td>" + vo.getEmail() + "</td>");
            out.print("<td>" + vo.getJoinDate() + "</td>");
            out.print("<td><a href='/ServletExtendedAPI_war_exploded/member?command=delMember&id=" + vo.getId() + "'> DEL</a></td></tr>");
        }
        out.print("</table></body></html>");
        out.print("<a href='/ServletExtendedAPI_war_exploded/memberForm.html'>NEW MEMBER</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
