package servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContextParamServlet", value = "/initMenu")
public class ContextParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String menu_member = context.getInitParameter("menu_member");
        String menu_order = context.getInitParameter("menu_order");
        String menu_goods = context.getInitParameter("menu_goods");

        out.print("<html><body><table border=1 cellspacing=0><tr>MENU NAMES</tr");
        out.print("<tr><td>" + menu_member + "</td><tr>");
        out.print("<tr><td>" + menu_order + "</td><tr>");
        out.print("<tr><td>" + menu_goods + "</td><tr>");
        out.print("</tr></table></body></html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
