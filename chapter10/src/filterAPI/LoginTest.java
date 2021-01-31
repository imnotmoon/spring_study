package filterAPI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "LoginTest", value = "/login")
public class LoginTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user_name = request.getParameter("user_name");
        String user_pw = request.getParameter("user_pw");

        out.println("<html><body> Name is : " + user_name + "<br>Password is : " + user_pw + "<br></body></html");
    }
}
