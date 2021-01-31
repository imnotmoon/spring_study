package urlpattern;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "TestServlet3", value = "*.do")
@WebServlet(name = "TestServlet3", value = "/*")
public class TestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String context = request.getContextPath();
        String url = request.getRequestURL().toString();
        String mapping = request.getServletPath();
        String uri = request.getRequestURI();

        out.println("<html><head><title>Test Servlet1</title></head>");
        out.println("<body bgcolor='blue'><b>Context Name : " + context + "</b><br>");
        out.println("<b>Full Path : " + url + "</b><br> <b>Mapping Name : " + mapping + "</b><br>");
        out.println("<b>URI : " + uri + "</b></body></html");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
