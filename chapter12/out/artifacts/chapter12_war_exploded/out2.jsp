<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 5:18 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
%>

<html>
<head>
    <title>내장객체 OUT을 이용한 실습2</title>
</head>
<body>
    <% if(name != null || name.length() > 0) { %>
        <h1><%=name%>, <%=age%></h1><br>
    <% } else { %>
        <h1>이름으 입력하세요.</h1><br>
    <% } %>

    <% if(name != null || name.length() > 0) { %>
        <h1><% out.println(name + ", " + age); %></h1><br>
    <% } else { %>
        <h1>이름을 입력하세요.</h1><br>
    <% } %>
</body>
</html>
