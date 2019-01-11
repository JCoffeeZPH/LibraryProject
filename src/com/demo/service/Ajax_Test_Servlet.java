package com.demo.service;

import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2019/1/11
 * 16:25
 */
@WebServlet(name = "Ajax_Test_Servlet")
public class Ajax_Test_Servlet extends HttpServlet {//用于注册界面检查
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if("".equals(name) || "".equals(name.trim())){
            out.println("<font color=red>用户名不能为空</font>");
            System.out.println("用户名不能为空");
        }else{
            UserDAo userDAo = new UserDAo();
            boolean flag = userDAo.isExist(name);
            if(!flag){
                out.println("<font color=red>用户名已存在</font>");
                System.out.println("用户名已存在");
            }
        }
    }
}
