package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void init() throws ServletException {
        System.out.println("init method called");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        System.out.println("ID : " + user_id);
        System.out.println("PW : "+ user_pw);
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
