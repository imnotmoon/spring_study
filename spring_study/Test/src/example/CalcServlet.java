package example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        if (command != null && command.equals("calculate")) {
            String result = calculate(Float.parseFloat(won), operator);
            pw.print("<html><font size=10> RESULT </font><br>");
            pw.print("<html><font-size=10>" + result + "</font><br>");
            pw.print("<a href='/calc'> calc </a>");
            return;
        }

        /**
         * pw.print( html includes form tag>
         **/
    }

    private static String calculate(float won, String operator) {
        String result = null;

        float USD_RATE = 1.0F;
        float JPY_RATE = 1.0F;
        float CNY_RATE = 1.0F;
        float GBP_RATE = 1.0F;
        float EUR_RATE = 1.0F;

        if(operator.equals("dollar")) {
            result = String.format("%.6f", won / USD_RATE);
        } else if(operator.equals("en")) {
            result = String.format("%.6f", won / JPY_RATE);
        } else if(operator.equals("wian")) {
            result = String.format("%.6f", won / CNY_RATE);
        } else if(operator.equals("pound")) {
            result = String.format("%.6f", won / GBP_RATE);
        } else if(operator.equals("euro")) {
            result = String.format("%.6f", won / EUR_RATE);
        }
        return result;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
