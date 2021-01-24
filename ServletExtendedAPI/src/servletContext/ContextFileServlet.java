package servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.StringTokenizer;

@WebServlet(name = "ContextFileServlet", value = "/cfile")
public class ContextFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

        String menu = null;
        String menu_member = null;
        String menu_order = null;
        String menu_goods = null;
        while((menu=buffer.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(menu, ",");
            menu_member = tokens.nextToken();
            menu_order = tokens.nextToken();
            menu_goods = tokens.nextToken();
        }

        out.print("<html><body>");
        out.print(menu_member + "<br>");
        out.print(menu_order + "<br>");
        out.print(menu_goods + "<br>");
        out.print("</body></html");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
