package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Kingrubin extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("called init method");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("called to get method");

    }

    @Override
    public void destroy() {
        
    }
}
