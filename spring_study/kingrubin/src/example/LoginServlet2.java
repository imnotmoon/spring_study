package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet2 extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("init method called");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");

        String data = "<html>";
        data += "<body>";
        data += "ID : " + user_id + "<br>";
        data += "PW : " + user_pw;
        data += "</body>";
        data += "</html>";
        out.print(data);

    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
