<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 10:52 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    Integer score = Integer.parseInt(request.getParameter("score"));
%>

<html>
<head>
    <title>점수 출력창</title>
</head>
<body>

<h1>시험점수 <%=score%>점.</h1> <br>

<script type="text/javascript">
    window.onload = () => {
        if("<%=score%>" > 100) {
            alert("Error");
            location.href = "/chapter12/scoreTest.html"
        } else if("<%=score%>"< 0) {
            alert("Error");
            location.href = "/chapter12/scoreTest.html"
        }

    }
</script>

<% if(score >= 90) {%>
    <h1>A학점입니다.</h1>
<% } else if(score >= 80 && score < 90) {%>
    <h1>B학점입니다.</h1>
<% } else {%>
    <h1>침팬지입니다.</h1>
<% } %>

<br>
<a href="scoreTest.html">시험점수 다시 입력하기.</a>

</body>
</html>
