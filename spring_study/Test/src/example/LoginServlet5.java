package example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet5", value = "/login5")
public class LoginServlet5 extends HttpServlet {

    public void init() {
        System.out.println("init method called");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        String address = request.getParameter("user_address");

        System.out.println("ID : " + id);
        System.out.println("PW : " + pw);

        String data = "<html>";
        data += "<body>";
        data += "ID : " + id;
        data += "<br> PW : " + pw + "<br>";
        data += "address : " + address + "<br>";
        data += "</body></html";
        out.print(data);
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
