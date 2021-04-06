<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/4/5
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    登录页面<br/>
    <form action="http://localhost:8080/10_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/><br/>
        密 码：<input type="password" name="password"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
