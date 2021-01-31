package loginexample;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession sess = request.getSession();

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        MemberVO memberVO = new MemberVO();
        memberVO.setId(user_id);
        memberVO.setPwd(user_pw);

        MemberDAO memberDAO = new MemberDAO();
        boolean result = memberDAO.isExisted(memberVO);
        List<MemberVO> list = memberDAO.listMembers();
        System.out.println(list);

        if(result) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogon", true);
            session.setAttribute("login.id", user_id);
            session.setAttribute("login.pwd", user_pw);
            out.println("<html><body> Hello " + user_id + "!!!<br>");
            out.println("<a href='show'> Account Info </a></body></html>");
        } else {
            out.println("<html><body><center> WRONG ID.");
            out.println("<a href='login3.html'> RETRY </a>");
            out.println("</body></html>");
        }
    }
}
