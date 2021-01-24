package loadOnStartUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loadConfig", value = "/loadConfig", loadOnStartup = 1)       // priority
public class LoadAppConfig extends HttpServlet {

    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LoadAppConfig - init method called");
        context = config.getServletContext();       // get ServletContext by config

        String menu_member = context.getInitParameter("menu_member");
        String menu_order = context.getInitParameter("menu_order");
        String menu_goods = context.getInitParameter("menu_goods");

        context.setAttribute("menu_member", menu_member);
        context.setAttribute("menu_order", menu_order);
        context.setAttribute("menu_goods", menu_goods);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //ServletContext context = getServletContext();
        String menu_member = (String) context.getAttribute("menu_member");
        String menu_order = (String) context.getAttribute("menu_order");
        String menu_goods = (String) context.getAttribute("menu_goods");

        out.print("<html><body><table border=1 cellspacing=0><tr>MENU NAME</tr>");
        out.print("<tr><td>" + menu_member + "</td></tr><td><td>" + menu_order + "</td></tr><tr><td>" + menu_goods + "</td><tr>");
        out.print("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
