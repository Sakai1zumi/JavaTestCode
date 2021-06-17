<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/4/25
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="hello">hello</a><br/>
  <a href="handle01">转发至hello.jsp页面</a><br/>
  <a href="handle02">转发至handle01再转发至hello.jsp页面</a><br/>
  <a href="handle03">重定向至hello.jsp页面</a><br/>
  <a href="handle04">重定向至handle01再重定向至hello.jsp页面</a><br/>
  <a href="toLoginPage">发送请求来到login.jsp页面</a>
  </body>
</html>
