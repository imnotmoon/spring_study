<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 4:49 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) session.getAttribute("name");
    session.setAttribute("address", "서울시 송파구");

%>

<html>
<head>
    <title>내장 객체 SESSION 테스트 1</title>
</head>
<body>
    이름은 <%=name%>입니다.
    <a href="session2.jsp">두번째 페이지로 이동..</a>
</body>
</html>
