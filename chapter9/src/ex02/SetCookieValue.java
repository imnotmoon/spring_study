package ex02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet(name = "SetCookieValue", value = "/set")
public class SetCookieValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Date d = new Date();
        Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP Programming", "utf-8"));
//        c.setMaxAge(24 * 60 * 60);        // Persistence Cookie
        c.setMaxAge(-1);            // Session Cookie
        response.addCookie(c);      // send cookie to browser

        out.println("CURRENT TIME : " + d);
        out.println("SAVE TEXT INTO COOKIE");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
