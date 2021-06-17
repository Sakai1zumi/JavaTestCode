<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/6/15
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<%
    request.setAttribute("ctp",request.getContextPath());
%>
<h1>修改&nbsp;${requestScope.employee.lastName}</h1>
<form:form action="${ctp}/emp/${employee.id}" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="id" value="${employee.id}"/>
    Email:<form:input path="email"/><br/>
    Gender:<form:radiobutton path="gender" value="1"/>Male<form:radiobutton path="gender" value="0"/>Female<br/>
    Departments:<form:select items="${departments}" path="department.id" itemLabel="departmentName" itemValue="id"></form:select><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
