<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 10:07 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String name = "문상혁";
    public String getName() { return name; }
%>
<% String age = request.getParameter("age"); %>

<html>
<head>
    <title>표현식 연습</title>
</head>
<body>
    <h1>안녕하세요 <%=name%></h1>
    <h1>나이는 <%=age%>살입니다</h1>
    <h1>키는 <%=180%>cm 입니다</h1>
    <h1>나이+10은 <%=Integer.parseInt(age) + 10%>살 입니다.</h1>
</body>
</html>
