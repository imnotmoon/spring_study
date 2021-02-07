<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 5:07 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setAttribute("name", "문상혁");
    application.setAttribute("address", "서울시 송파구");
%>

<html>
<head>
    <title>내장 객체 스코프 테스트1</title>
</head>
<body>
    <h1>이름과 주소를 저장합니다.</h1><br>
    <a href="appTest2.jsp">두 번째 웹 페이지로 이동...</a>
</body>
</html>
