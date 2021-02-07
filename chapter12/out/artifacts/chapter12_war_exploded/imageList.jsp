<%--
  Created by IntelliJ IDEA.
  User: imnotmoon
  Date: 2021/02/07
  Time: 11:34 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>이미지 리스트 만들기</title>
</head>
<body>
    <ul class="lst_type">
<%--        header --%>
        <li>
            <span style="margin-left: 50px">이미지</span>
            <span>이미지 이름</span>
            <span>선택하기 </span>
        </li>

        <% for(int i=0; i<10; i++) {%>
            <li>
                <a href="#" style="margin-left: 50px">
                    <img src="./image/IMG_1F414CD7E436-1.jpeg" width="90" height="90" alt="미니언">
                </a>
                <a href="#"><strong>이미지 이름 : 미니언 <%=i%>번 </strong></a>
                <a href="#"><input type="checkbox" name="chk<%=i%>"></a>
            </li>
        <% } %>
    </ul>
</body>
</html>
