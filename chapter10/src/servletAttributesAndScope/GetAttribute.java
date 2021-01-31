package servletAttributesAndScope;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetAttribute", value = "/get")
public class GetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;chaset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext ctx = getServletContext();
        HttpSession sess = request.getSession();

        String ctxMsg = (String) ctx.getAttribute("context");
        String sesMsg = (String) sess.getAttribute("session");
        String reqMsg = (String) request.getAttribute("request");

        out.print("from context : " + ctxMsg);
        out.print("from session : " + sesMsg);
        out.print("from request : " + reqMsg);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
