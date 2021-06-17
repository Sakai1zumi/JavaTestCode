<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/6/15
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>员工列表</title>
</head>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<body>
<%
    request.setAttribute("ctp",request.getContextPath());
%>
<h1>员工列表页面</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Department</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.employees}" var="employee">
    <tr>
        <td>${employee.id}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
        <td>${employee.gender==0?"Female":"Male"}</td>
        <td>${employee.department.departmentName}</td>
        <td><a href="${ctp}/emp/${employee.id}">Edit</a></td>
        <td><a href="${ctp}/emp/${employee.id}" class="deleteBtn">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<a href="${ctp}/toAddEmp">添加员工</a>

<form id="deleteForm" action="" method="post">
    <input type="hidden" name="_method" value="delete"/>
</form>
<script type="text/javascript">
    $(function () {
       // alert("hello");
        $(".deleteBtn").click(function () {
            var isDelete = confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗？");
            if(isDelete){
                //1. 更改表单的提交请求地址
                $("#deleteForm").attr("action",this.href);
                //2. 表单提交
                $("#deleteForm").submit();
            }
            return false;
        });
    });
</script>
</body>
</html>
