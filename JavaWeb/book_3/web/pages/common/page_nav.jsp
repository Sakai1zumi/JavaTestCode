<%--
  Created by IntelliJ IDEA.
  User: TuHong
  Date: 2021/3/30
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--分页条的开始--%>
<div id="page_nav">
    <%--当前页数大于首页即显示“首页”及“上一页”按钮--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <%--情况1：总页码小于等于5的情况，页码范围是1 - 总页码--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--情况2：总页码大于5的情况，假设一共为10页--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--小情况1：当前页码为前面3页，即1，2，3的情况，页码范围为1 - 5--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况2：当前页码为后面3个，即8，9，10的情况，页码范围为总页码减4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--小情况3：当前页码为中间范围，即3，4，5，6，7，页码范围为当前页码减2 - 当前页码加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <%--页码输出的结束--%>

    <%--当前页数小于末页即显示“末页”及“下一页”按钮--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id = "searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();

                location.href = "${requestScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo;
            })
        })
    </script>
</div>
<%--分页条的结束--%>
