<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 10:26 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");
%>

<html>
<head>
    <title>결과출력창</title>
</head>
<body>
<h1>아이디 : <%=user_id%></h1>
<h1>비밀번호 : <%=user_pw%></h1>
</body>
</html>
