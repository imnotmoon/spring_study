package ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTest2", value = "/sess2")
public class SessionTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // Session
        HttpSession sess = request.getSession();
        out.print("Session ID " + sess.getId() + "<br>");
        out.println("First Session Created : " + new Date(sess.getCreationTime()) + "<br>");
        out.println("First Session Access : " + sess.getLastAccessedTime() + "<br>");
        out.println("<br>");
        out.print("Default Session Validation Time : " + sess.getMaxInactiveInterval() + "<br>");
        sess.setMaxInactiveInterval(5);
        out.println("Session Validation Time : " + sess.getMaxInactiveInterval() + "<br>");

        if(sess.isNew()) {
            out.print("New Session Created");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
