<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    session.setAttribute("name",name);
%>
<center>
<h1>登录成功</h1>
<hr>
<a href="/showBooks.jsp">查看剩余书籍情况</a>
<br>
<a href="/returnBook.jsp">还书</a><br>
<a href="/borrowBook.jsp">借书</a><br>
<br>
<a href="/loginout.jsp">注销</a><br><br>
    <a href="/getmessage.jsp">查看借阅情况</a>
</center>
</body>
</html>
