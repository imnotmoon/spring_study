package servletConfig;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InitParamServlet", value = "/sInit",
        //urlPatterns = {"/sInit", "sInit2"},
        initParams = {@WebInitParam(name = "email", value= "admin@jweb.com"), @WebInitParam(name= "tel", value= "010-1111-2222")}
)
public class InitParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        String email = getInitParameter("email");
        String tel = getInitParameter("tel");

        out.print("<html><body>");
        out.print("<table><tr> <td>email: </td><td>" + email + "</td><td>tel: " + tel + "</td>");
        out.print("</tr></table></bodt></html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
