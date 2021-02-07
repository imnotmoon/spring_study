package session;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "SessionTest", value = "/sess")
public class SessionTest extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession sess = request.getSession();

        sess.setAttribute("name", "문상혁");
        out.println("<html><body>");
        out.println("<h1>세션에 이름을 바인딩합니다.<h1>");
        out.println("<a href='/chapter12/session1.jsp'> 첫번째 페이지로 이동. </a>");
        out.println("</body></html>");

    }
}
