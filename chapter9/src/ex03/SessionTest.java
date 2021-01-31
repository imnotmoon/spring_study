package ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTest", value = "/sess")
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // Use methods of HttpSession
        HttpSession session = request.getSession();
        out.println("SESS ID : " + session.getId() + "<br>");
        out.println("First Session Initialize : " + new Date(session.getLastAccessedTime()) + "<br>");
        out.println("First Session Access : " + session.getLastAccessedTime() + "<br>");
        out.println("Session Vaidation Time : " + session.getMaxInactiveInterval() + "<br>");

        if(session.isNew()) {
            out.print(("New Session Created"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
