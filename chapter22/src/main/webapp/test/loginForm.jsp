<%--
  Created by IntelliJ IDEA.
  User: munsanghyeog
  Date: 2021/02/15
  Time: 9:18 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="frmLogin" method="post" action="${contextPath}/test/login.do">
        <table border="1" width="80%" align="center">
            <tr align="center">
                <td>아이디</td>
                <td>비밀번호</td>
            </tr>
            <tr align="center">
                <td><input type="text" name="userID" value="" size="20"></td>
                <td><input type="password" name="passwd" value="" size="20"></td>
            </tr>
            <tr>
                <td><input type="submit"> </td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </form>

</body>
</html>
