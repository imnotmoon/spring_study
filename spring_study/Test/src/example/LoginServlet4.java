package example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet4", value = "/login4")
public class LoginServlet4 extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("init method called");
    }

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
        String user_id = request.getParameter("user_id");
        System.out.println("ID : " + user_id);
        String user_pw = request.getParameter("user_pw");
        System.out.println("PW : " + user_pw);
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
