<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/8/13
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查询所有</title>
</head>
<body>
<h1>${user.username},欢迎您</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>
                <c:if test="${brand.status == 1}">启用</c:if>
                <c:if test="${brand.status == 0}">禁用</c:if>
            </td>
            <td>
                <%--<input type="button" value="修改" id="update">
                <input type="button" value="删除" id="delete">--%>
                <a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="/brand-demo/deleteServlet?id=${brand.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/brand-demo/addBrand.jsp"
    }
</script>

<%--<script>--%>
<%--    document.getElementById("update").onclick = function (){--%>
<%--        location.href = "/brand-demo/selectByIdServlet?id=${brand.id}"--%>
<%--    }--%>
<%--</script>--%>

<%--<script>--%>
<%--    document.getElementById("delete").onclick = function (){--%>
<%--        var r = confirm("确定要删除吗？");--%>
<%--        if (r == true){--%>
<%--            location.href = "/brand-demo/deleteServlet?id=${brand.id}"--%>
<%--        }else {--%>
<%--            location.href = "/brand-demo/selectAllServlet"--%>
<%--        }--%>

<%--    }--%>
<%--</script>--%>

</body>
</html>
