<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/8/14
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        #loginMsg{
            color: red;
        }
    </style>
</head>
<body>

<form action="/brand-demo/loginServlet" method="post">
    <h1>LOGIN IN</h1>
    <div id="loginMsg">${login_msg} ${register_msg}</div>
    <p><label for="username">用户名：</label>
        <input type="text" name="username" id="username" value="${cookie.username.value}">
    </p>

    <p><label for="password">密码：</label>
        <input type="password" name="password" id="password" value="${cookie.password.value}">
    </p>
    <p>记住:<input type="checkbox" name="remember"></p>
    <input type="submit" value="登录">
    <a href="register.jsp">没有账号？点击注册</a>
</form>


</body>
</html>
