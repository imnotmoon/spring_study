package filterAPI;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "EncodeFilter", value = "/*")
public class EncodeFilter implements Filter {

    ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        System.out.println("utf-8 encoding -------------");
        context = config.getServletContext();
    }

    public void destroy() {
        System.out.println("utf-8 filter destoryed");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter called");
        request.setCharacterEncoding("utf-8");
        String context = ((HttpServletRequest) request).getContextPath();
        String pathinfo = ((HttpServletRequest) request).getRequestURI();
        String realpath = request.getRealPath(pathinfo);

        String msg = "Context Info : " + context + "\nURI Info : " + pathinfo + "\nPhysical Info : " + realpath;
        System.out.println(msg);

        // 10.3.4 : to get response time
        long begin = System.currentTimeMillis();

        chain.doFilter(request, response);

        // 10.3.4 : to get response time
        long end = System.currentTimeMillis();
        response.setContentType("text/html;charset=utf-8");
        System.out.println("Response Time : " + (end-begin) + "ms");
    }
}
