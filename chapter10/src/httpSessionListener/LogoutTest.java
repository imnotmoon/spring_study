package httpSessionListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogoutTest", value = "/logout")
public class LogoutTest extends HttpServlet {

    ServletContext context;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession sess = request.getSession();

        String user_id = request.getParameter("user_id");
        sess.invalidate();

        List user_list = (ArrayList) context.getAttribute("user_list");
        user_list.remove(user_id);
        context.removeAttribute("user_list");       // remove original user_list
        context.setAttribute("user_list", user_list);       // bind new user_list : user_id removed list
        out.println("<br>NOW LOGGED OUT");
    }
}
