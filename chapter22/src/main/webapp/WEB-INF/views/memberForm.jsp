<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munsanghyeog
  Date: 2021/02/15
  Time: 9:17 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" align="center" width="80%">
        <tr align="center" bgcolor="#90ee90">
            <td><b>아이디</b></td>
            <td><b>비밀번호</b></td>
            <td><b>이름</b></td>
            <td><b>이메일</b></td>
            <td><b>가입일</b></td>
        </tr>
        <c:forEach var="member" items="${membersList}" >
            <tr align="center">
                <td>${member.id}</td>
                <td>${member.pwd}</td>
                <td>${member.name}</td>
                <td>${member.email}</td>
                <td>${member.joinDate}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
