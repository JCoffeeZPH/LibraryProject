package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2018/12/10
 * 18:18
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        String sex= request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        user.setSex(sex);
        user.setTelephone(telephone);
        user.setEmail(email);

        UserDAo userDAo = new UserDAo();
        userDAo.addUser(user);
        System.out.println("注册成功");
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
}
