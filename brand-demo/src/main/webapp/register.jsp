<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/8/14
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎注册</title>
    <style>
        #registerMsg{
            color: red;
        }
    </style>
</head>
<body>

<h1>欢迎注册</h1>
<form action="/brand-demo/registerServlet" method="post">
    <p><label for="username">用户名：</label>
        <input type="text" name="username" id="username">
    </p>
    <div id="registerMsg">${register_msg}</div>
    <p><label for="password">密码：</label>
        <input type="password" name="password" id="password">
    </p>
    <input type="submit" value="注册">
</form>

</body>
</html>
