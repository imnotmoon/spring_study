package example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/third")
public class Test extends HttpServlet {

    public static final long serialVersionUID = 1L;

    /**
     * Servlet implementation class ThirdServlet
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("ThirdServlet init method called");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ThirdServlet doGet method called");
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
