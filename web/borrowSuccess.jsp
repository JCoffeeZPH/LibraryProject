<%@ page import="com.demo.dao.MessageDAo" %>
<%@ page import="com.demo.bean.Message" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅成功</title>
</head>
<body>
<%
    String book_name = request.getParameter("book_name");
    int x = (int)request.getAttribute("sum");
    if(x != -1){
        out.write("借阅《" + request.getParameter("book_name") +"》成功");
        String name = (String) session.getAttribute("name");
        Message message = new Message();
        message.setName(name);
        message.setBook_name(book_name);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setDate(simpleDateFormat.format(new Date()));
        MessageDAo messageDAo = new MessageDAo();
        messageDAo.addMessage(message);
    }
    else
        out.write("《" + request.getParameter("book_name") + "》" + "已全部被借阅");
%><br><br>
<a href="/returnBook.jsp">还书</a><br>
<a href="/borrowBook.jsp">借书</a><br>
<a href="/loginout.jsp">注销</a><br><br>
<a href="/getmessage.jsp">查看借阅情况</a>

</body>
</html>
