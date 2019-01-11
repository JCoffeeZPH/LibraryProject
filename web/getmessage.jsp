<%@ page import="com.demo.bean.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.dao.MessageDAo" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户借阅情况</title>
</head>
<body>
<%
      String name = (String) session.getAttribute("name");
      MessageDAo messageDAo = new MessageDAo();
      List<Message> list = messageDAo.getMessage(name);
      for(Message list1: list){
          out.write(list1.getBook_name() + " <---> " + list1.getDate());
          out.write("<br>");
      }
%><br>
<hr>
<a href="/returnBook.jsp">还书</a><br>
<a href="/borrowBook.jsp">借书</a><br>
<br>
<a href="/loginout.jsp">注销</a><br><br>
</body>
</html>
