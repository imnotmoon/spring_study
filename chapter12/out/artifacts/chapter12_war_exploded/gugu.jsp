<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 11:10 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    int dan = Integer.parseInt(request.getParameter("dan"));
%>

<html>
<head>
    <title>구구단 출력</title>
</head>
<body>
    <table border="1" width="800">
        <tr align="center" bgcolor="#FFFF66">
            <td colspan="2"><%=dan%>단 출력</td>
        </tr>

        <% for(int i=1; i<11; i++) {%>
        <tr align="center">
            <td width="400">
                <%=dan%> * <%=i%>
            </td>
            <td width="400"> <%=i*dan%> </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
