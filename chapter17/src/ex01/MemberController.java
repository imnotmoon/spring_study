package ex01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", value = "/mem.do")
public class MemberController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    public void init() throws ServletException {
        memberDAO = new MemberDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<MemberVO> membersList = memberDAO.listMembers();
        System.out.println(membersList);
        request.setAttribute("membersList", membersList);
        RequestDispatcher dispatch = request.getRequestDispatcher("/ex01/listMembers.jsp");
        dispatch.forward(request, response);
    }
}
