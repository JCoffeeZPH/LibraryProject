<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style type="text/css">
        body{
            background-position: center;
            background-repeat: no-repeat;
        }
    </style>

</head>
<body>
<div style="text-align:center;margin-top:120px">
    <%--<h2>ForMe的主页</h2>--%>
    <form action="/LoginServlet" method="post">
    <table style="margin-left:40%">
        <marquee width="200" scrolldelay="250">用户登录</marquee>

        <tr>
            <td>用户名：</td>
            <td><input type="text" size="21" name="name" id="name"/></td>

        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" size="21" /></td>
        </tr>

    </table>

    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
    </form><br>
    <a href="register.jsp">注册</a>
</div>
</body>
</html>
