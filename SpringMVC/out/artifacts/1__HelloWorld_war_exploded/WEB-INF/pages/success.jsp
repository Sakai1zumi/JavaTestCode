<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/4/21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>
    <%--request:${requestScope.reqParam}<br/>
    session:${sessionScope.sessionParam}<br/>--%>
    pageContext:${pageScope.msg}<br/>
    request:${requestScope.msg},${requestScope.haha}<br/>
    session:${sessionScope.msg},${sessionScope.haha}<br/>
    application:${applicationScope.msg}<br/>
</body>
</html>
