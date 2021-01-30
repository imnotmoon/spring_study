package ex01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        String user_address = request.getParameter("user_address");
        String user_email = request.getParameter("user_email");
        String user_hp = request.getParameter("user_hp");

        String data = "Hello <br> Now Logged in. <br><br>";
        data += "<html><body>";
        data += "ID : " + user_id + "<br>";
        data += "PW : " + user_pw + "<br>";
        data += "Address : " + user_address + "<br>";
        data += "Email : " + user_email + "<br>";
        data += "HP : " + user_hp + "<br>";

//        out.print(data);

        user_address = URLEncoder.encode(user_address, "utf-8");
        data += ("<a href='/chapter9/second?user_id=" + user_id + "&user_pw=" + user_pw + "&user_address=" + user_address + "'> to Second Servlet </a>");
        data += ("</body></html>");

        out.print(data);
    }

    public void destroy() {
        System.out.println("destroy method called!");
    }
}