<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 5:07 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) session.getAttribute("name");
    String address = (String) application.getAttribute("address");
%>

<html>
<head>
    <title>내장 객체 스코프 테스트2</title>
</head>
<body>
<%--    세션은 브라우저 스코프. 다른 브라우저나 시크릿모드로 진입하면 null을 찍는다. 세션이 없어서--%>
    <h1>이름은 <%=name%> 입니다. </h1> <br>
    <h1>주소는 <%=address%> 입니다.</h1> <br>
</body>
</html>
