<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 5:12 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("name", "문상혁");
    request.setAttribute("address", "서울시 송파구");
%>

<html>
<head>
    <title>리퀘스트 바인딩 실습1</title>
</head>
<body>
    <%
        RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
//        디스패쳐를 이용한 포워딩. url은 안바뀌고 포워드된다.
        dispatch.forward(request, response);
    %>
</body>
</html>
