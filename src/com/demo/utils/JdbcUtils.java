package com.demo.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by ForMe
 * com.demo.utils
 * 2018/12/10
 * 17:09
 */
public class JdbcUtils {
    private static String URL = null;
    private static String ROOT = null;
    private static String PASS = null;
    private static String DRIVER = null;

    static{
        Properties properties = new Properties();
        InputStream inputStream = JdbcUtils.class.getResourceAsStream("/library.properties");
        try {
            properties.load(inputStream);
            URL = properties.getProperty("url");
            ROOT = properties.getProperty("root");
            PASS = properties.getProperty("password");
            DRIVER = properties.getProperty("driver");
            Class.forName(DRIVER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(URL,ROOT,PASS);
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
