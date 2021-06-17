<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/6/15
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<%
    request.setAttribute("ctp",request.getContextPath());
%>
<h1>添加员工</h1>
<%--
表单标签：
1. 使用SpringMVC表单标签可以实现将模型中的属性和HTML表单元素相绑定，以实现表单数据更便捷的编辑和表单值的回显
2. 在SpringMVC中使用form表单标签，path指定的属性，必须要在隐含模型中找到某个对象，该对象拥有这一属性，默认对象名为command，使用modelAttribute可以修改默认寻找的对象名
--%>
<form:form  action="${ctp}/emp" modelAttribute="employee" method="post">
    <%--
    path:
        1. 原生input标签的name属性值
        2. 自动回显隐含模型中某个对象对应的该属性的值
    --%>
    LastName:<form:input path="lastName"/><br/>
    Email:<form:input path="email"/><br/>
    Gender:<form:radiobutton path="gender" value="1"/>Male <form:radiobutton path="gender" value="0"/>Female<br/>
    <%--
    items：指定要遍历的集合
    itemLabel：指定遍历出来的对象的哪个属性作为option标签体的值
    itemValue：指定历出来的对象的哪个属性作为要提交的Value属性值
    --%>
    Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></form:select><br/>
    <input type="submit" value="Submit"/>
</form:form>


<%--<form action="addEmp">
    LastName:<input type="text" name="lastName"><br/>
    Email:<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender" value="1">Male <input type="radio" name="gender" value="0">Female<br/>
    Department:
    <select>
        <c:forEach items="${requestScope.departments}" var="department">
            <option value="${department.id}">${department.departmentName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>--%>
</body>
</html>
