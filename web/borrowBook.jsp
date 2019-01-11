<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书</title>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
<form action="BorrowBookServlet" method="post">
    <table style="margin-left:40%">
        <a href="showBooks.jsp">查看书籍的情况</a><br>
        <tr>
            书名：<input type="text" name="book_name" >
        </tr>
        <tr>
            <input type="submit" value="借阅">
        </tr>
    </table>
    <a href="/loginout.jsp">注销</a>
</form>
</div>
</body>
</html>
