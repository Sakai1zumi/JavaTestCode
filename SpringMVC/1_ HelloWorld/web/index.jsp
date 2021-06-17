<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/4/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="handle01">test01-写在方法上的@RequestMapping</a><br/>
  <a href="haha/handle01">test02-写在类上的@RequestMapping</a><br/>
  <h1>测试RequestMapping属性</h1>
  <a href="haha/handle02">测试method属性</a><br/>
  <form action="haha/handle02" method="post">
    <input type="submit">
  </form>
  <a href="haha/handle03">测试params属性</a><br/>
  <a href="haha/handle04">测试headers</a>

  <%--
  使用REST风格的URL地址
  请求url   请求方式    表示含义
  /book/1   GET        查询1号图书
  /book/1   DELETE     删除1号图书
  /book/1   PUT        更新1好图书
  /book     POST       添加1号图书
  --%>
  <h1>测试REST风格的URL地址</h1>
  <a href="book/1">查询1号图书</a><br/>
  <form action="book" method="post">
    <input type="submit" value="添加图书">
  </form>

  <%--发送DELETE请求--%>
  <form action="book/1" method="post">
    <input type="submit" value="删除1号图书">
    <input name="_method" value="delete" type="hidden">
  </form>

  <%--发送PUT请求--%>
  <form action="book/1" method="post">
    <input type="submit" value="更新1号图书">
    <input name="_method" value="PUT" type="hidden">
  </form>

  <h1>测试获取参数</h1>
  <a href="param/handle01?user=tomcat">handle01</a><br/>
  <form action="param/book" method="post">
    书名：<input type="text" name="bookName"/><br/>
    作者：<input type="text" name="author"/><br/>
    价格：<input type="text" name="price"/><br/>
    库存：<input type="text" name="stock"/><br/>
    销量：<input type="text" name="sales"/><br/>
    <hr/>
    省：<input type="text" name="address.province"/>
    市：<input type="text" name="address.city"/>
    街道：<input type="text" name="address.street"/>
    <input type="submit"/>
  </form>

  <h1>SpringMVC保存数据</h1>
  <a href="output/handle01">handle01</a><br/>
  <a href="output/handle02">handle02</a><br/>
  <a href="output/handle03">handle03</a><br/>
  <a href="output/handle04">handle04</a><br/>

  <h1>测试ModelAttribute注解</h1>
  <form action="updateBook" method="post">
    <input type="hidden" name="id" value="100">
    书名：西游记<br/>
    作者：<input type="text" name="author"><br/>
    价格：<input type="text" name="price"><br/>
    库存：<input type="text" name="stock"><br/>
    销量：<input type="text" name="sales"><br/>
    <input type="submit">
  </form>

  </body>
</html>
