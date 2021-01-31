package ex06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "SessionTest5", value = "/login")
public class SessionTest5 extends HttpServlet {
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

        if (sess.isNew()) {      // when first login
            if (user_id != null) {
                // if validate
                sess.setAttribute("user_id", user_id);
                String url = response.encodeURL("login");       // save jsessionId
                out.println("<a href=" + url + "?jsessionid=" + sess.getId() + "> Check Login Status </a>");
            } else {
                out.println("Login Again");
                sess.invalidate();
            }
        } else {                // when request again
            // get id from session -> check if it is validate
            user_id = (String) sess.getAttribute("user_id");
            if (user_id != null && user_id.length() != 0) {
                out.println("Hello, " + user_id + "!!!!");
            } else {
                out.println("<a href='login2.html'> Login Again! </a>");
                sess.invalidate();
            }
        }
    }

}
