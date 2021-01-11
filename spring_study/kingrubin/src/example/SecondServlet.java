package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init method called >>>>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet method called >>>>");

    }

    @Override
    public void destroy() {
       System.out.println("destroy method called >>>>");
    }
}
