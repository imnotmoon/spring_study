<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 10:02 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String name = "이순신";
    public String getName() {
        return name;
    }
%>

<% String age = request.getParameter("age"); %>
<%--request with query string--%>
<html>
<head>
    <title>스크립트릿 연습</title>
    <h1>안녕하세요 <%=name%></h1>
    <h1>나이는 <%=age%> 살 입니다.</h1>
</head>
<body>

</body>
</html>
