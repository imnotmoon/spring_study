package loginexample;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowMember", value = "/show")
public class ShowMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Boolean isLogon = false;
        String id="", pwd = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            isLogon = (Boolean) session.getAttribute("isLogon");
            if(isLogon) {
                id = (String) session.getAttribute("login.id");
                pwd = (String) session.getAttribute("login.pwd");
                out.println("<html><body>ID : " + id + "<br>PWD : " + pwd + "<br></body></html>");
            } else {
                response.sendRedirect("login3.html");
            }
        } else {
            response.sendRedirect("login3.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
