package com.demo.dao;

import com.demo.bean.Message;
import com.demo.bean.User;
import com.demo.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ForMe
 * com.demo.dao
 * 2018/12/11
 * 16:59
 */
public class MessageDAo {
    public List<Message> getMessage(String name){//查阅所借书
        List<Message> list = new ArrayList<>();
        Message m = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from message where name=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                m = new Message();
                m.setBook_name(resultSet.getString("name"));
                m.setBook_name(resultSet.getString("book_name"));
                m.setDate(resultSet.getString("date"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    public  void addMessage(Message mess){//增加所借书
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into message(name,book_name,date) values (?,?,?)";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,mess.getName());
            preparedStatement.setString(2,mess.getBook_name());
            preparedStatement.setString(3,mess.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }

    }

    public void returnMessage(String name, String book_name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from message where name=? and book_name=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,book_name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }
    }

    public boolean check(String name, String book_name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from message where name=? and book_name=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,book_name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name1 = resultSet.getString("name");
                String book_name1 = resultSet.getString("book_name");
                //System.out.println(name1 + "==" + book_name1);
                if(name.equals(name1) && (book_name).equals(book_name1)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }
}
