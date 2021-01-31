package httpSessionListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginTest2", value = "/login")
public class LoginTest2 extends HttpServlet {

    ServletContext context = null;
    List user_list = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");        // now filtered
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession sess = request.getSession();
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println(user_id);
        System.out.println(user_pw);

        // Event Handler
        LoginImpl loginUser = new LoginImpl(user_id, user_pw);

        if(sess.isNew()) {
            System.out.println("new user");
            sess.setAttribute("loginUser", loginUser);      // Bind LoginImpl to Session. Each Session has LoginImpl
            // Event Occured
            user_list.add(user_id);
            context.setAttribute("user_list", user_list);
        }

        out.println("<head><script type='text/javascript'>");
        out.println("setTimeout('history.go(0);', 5000)");
        out.println("</script></head><html><body>ID : " + loginUser.user_id + "<br>TOTAL : " + LoginImpl.total_user + "<br>");
        out.println("Access ID :<br>");
        List list = (ArrayList) context.getAttribute("user_list");
        for(int i=0; i<list.size(); i++) {
            out.println(list.get(i) + "<br>");
        }
        out.println("<a href='logout?user_id=" + user_id + "'> LOGOUT </a>");
        out.println("</body></html>");
    }
}
