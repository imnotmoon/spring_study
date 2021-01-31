package servletAttributesAndScope;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SetAttribute", value = "/set")
public class SetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String ctxMsg = "bind to Context";
        String sesMsg = "bind to Sess";
        String reqMsg = "bind to Request";

        ServletContext ctx = getServletContext();
        HttpSession ses = request.getSession();

        ctx.setAttribute("context", ctxMsg);
        ses.setAttribute("session", sesMsg);
        request.setAttribute("request", reqMsg);

        out.print("binded");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
