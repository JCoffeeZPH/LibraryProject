<%@ page import="com.demo.dao.MessageDAo" %>
<%@ page import="com.demo.bean.Book" %>
<%@ page import="com.demo.dao.BookDAo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>归还界面</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String book_name = request.getParameter("book_name");
    BookDAo bookDAo = new BookDAo();
    MessageDAo messageDAo = new MessageDAo();
    Book book = bookDAo.retandborBook(book_name);
    String name = (String) session.getAttribute("name");
   // System.out.println(name + ":" + book_name);
    boolean flag = messageDAo.check(name,book_name);
    if(flag) {
        out.write("归还 《" + book_name + "》成功");
        messageDAo.returnMessage(name,book_name);
        bookDAo.update(book,1);
    }
    else {
        out.write("您的操作错误: 尚未借阅本书<br>");
    }
    //out.write();
    //System.out.println();
%><br><br>
<a href="/returnBook.jsp">还书</a><br>
<a href="/borrowBook.jsp">借书</a>
</body>
</html>
