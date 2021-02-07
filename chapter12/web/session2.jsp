<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 4:50 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) session.getAttribute("name");
    String address = (String) session.getAttribute("address");
%>

<html>
<head>
    <title>내장 객체 SESSION 테스트 2</title>
</head>
<body>
    이름은 <%=name%>입니다. <br>
    주소는 <%=address%>입니다.<br>

</body>
</html>
