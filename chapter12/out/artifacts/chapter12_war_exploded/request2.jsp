<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/08
  Time: 5:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) request.getAttribute("name");
    String address = (String) request.getAttribute("address");
//    리퀘스트 객체를 request1.jsp로부터 그대로 넘겨받음...
%>

<html>
<head>
    <title>리퀘스트 바인딩 실습2</title>
</head>
<body>
    <h1>이름은 <%=name%> 입니다.</h1><br>
    <h1>주소는 <%=address%> 입니다.</h1>
</body>
</html>
