package com.demo.dao;

import com.demo.bean.User;
import com.demo.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ForMe
 * com.demo.dao
 * 2018/12/10
 * 17:19
 */
public class UserDAo {
    public User Login(String name, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = JdbcUtils.getConn();
            String sql = "select * from reader where name=? and password=?";
            preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return user;
    }

    public void addUser(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConn();
            String sql = "insert into reader(name,password,id,sex,telephone,email) values (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getId());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setString(5,user.getTelephone());
            preparedStatement.setString(6,user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement);
        }
    }

    public boolean isExist(String username){
        Connection connection = null;
        String sql = "select * from reader where name=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public List<String> showBook(){//剩余各种书的信息
        List<String> list = new ArrayList<>();
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConn();
            String sql = "select * from book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String message = "书名：" + resultSet.getString("book_name")
                        + "<--->剩余数量：" + resultSet.getInt("book_num")
                        + "<--->作者为：" + resultSet.getString("book_writer")
                        + "<--->书的价格为：" + resultSet.getInt("book_price")
                        + "<--->出版时间为：" + resultSet.getString("publish_time")
                        + "<--->出版社为：" + resultSet.getString("publish_house");
                list.add(message);
//                System.out.println(message);
                //System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
