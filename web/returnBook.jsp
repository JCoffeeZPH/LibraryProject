<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>还书</title>
    <style type="text/css">
        body{
            background-repeat: no-repeat;
            background-position: center;
        }
    </style>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
<form action="returnSuccess.jsp" method="post">
    <table style="margin-left:40%">
         <%--<caption>添加书籍</caption>--%>
        <tr>
            书名：<input type="text" name="book_name">
        </tr>
        <tr>
            <input type="submit" value="归还">
        </tr>
    </table>
</form>
    <a href="/loginout.jsp">注销</a>
</div>
</body>
</html>
