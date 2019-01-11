package com.demo.dao;

import com.demo.bean.Book;
import com.demo.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ForMe
 * com.demo.dao
 * 2018/12/11
 * 12:43
 */
public class BookDAo {
    public void addBook(Book book){//添加图书
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into book(book_num,book_name,book_writer,book_price,publish_time,publish_house)" +
                "values(?,?,?,?,?,?)";
        try {
            preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setInt(1,book.getBook_num() + 1);
            preparedStatement.setString(2,book.getBook_name());
            preparedStatement.setString(3,book.getBook_writer());
            preparedStatement.setInt(4,book.getBook_price());
            preparedStatement.setString(5,book.getPublish_time());
            preparedStatement.setString(6,book.getPublish_house());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement);
        }

    }

    public Book retandborBook(String book_name){//借/还书
        Book book = null;
        Connection  connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from book where book_name=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book_name);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                book = new Book();
                book.setBook_num(resultSet.getInt("book_num"));
                book.setBook_name(resultSet.getString("book_name"));
                book.setBook_writer(resultSet.getString("book_writer"));
                book.setBook_price(resultSet.getInt("book_price"));
                book.setPublish_time(resultSet.getString("publish_time"));
                book.setPublish_house(resultSet.getString("publish_house"));
//              //System.out.println("归还 《" + book_name + "》成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return book;
    }

    public int update(Book book,int i){//更新书籍数量
        int sum = (book.getBook_num() + i);
        if(sum < 0){
            return -1;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update book set book_num='" + sum +"' where book_name='" + book.getBook_name()+"'";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }
        return 0;
    }
}
