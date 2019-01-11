<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <style type="text/css">
        body{
            background-repeat: no-repeat;
            background-position: center;
        }
    </style>

    <script type="text/javascript">
        function ajax(){
            var ajax = new XMLHttpRequest();
            var name = document.getElementById("name").value;
            var url = "Ajax_Test_Servlet";
            ajax.open("post",url,true);
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.onreadystatechange = function(){
                if(ajax.readyState == 4 && ajax.status == 200){
                    var text = ajax.responseText;
                    var spanText = document.getElementById("checkname");
                    spanText.innerHTML = text;
                }
            }
            ajax.send("name=" + name);
        }
    </script>

</head>
<body>

<div style="text-align:center;margin-top: 120px">
    <form action="/RegisterServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户注册</caption>
            <tr>
                <td>用户名:</td>
                <td><input name="name" type="text" size="20" id="name" onblur="ajax();"><span id="checkname"></span></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" size="20" ></td>
            </tr>
            <tr>
                <td>ID:</td>
                <td><input name="id" type="text" size="20" ></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input name="sex" type="text" size="10" ></td>
            </tr>
            <tr>
                <td>联系方式:</td>
                <td><input name="telephone" type="text" size="10" ></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input name="email" type="text" size="10" ></td>
            </tr>
        </table>
        <input type="submit" value="注册"/>
        <input type="reset" value="重置" />
    </form>
    <br>
    <a href="login.jsp">登录</a>
    </form>
</div>
</body>
</html>
