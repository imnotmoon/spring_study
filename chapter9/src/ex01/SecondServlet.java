package ex01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", value = "/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        String user_address = request.getParameter("user_address");

        out.println("<html><body>");
        if(user_id != null && user_id.length() != 0) {
            out.println("already logged in! <br><br>");
            out.println("ID from first servlet : " + user_id + "<br>");
            out.println("PW from first servlet : " + user_pw + "<br>");
            out.println("Address from first servlet : " + user_address + "<br>");
        } else {
            out.println("NOT LOGGED IN <br><br>");
            out.println("do it again");
            out.println("<a href = '/chapter9/login.html> TO LOGIN VIEW </a>");
        }

        out.print("</body></html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("destroy method called");
    }
}
