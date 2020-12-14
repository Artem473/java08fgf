package ru.sapteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String URL = "jdbc:mysql://localhost:3306/auto?serverTimezone=UTC";
    public final String LOGIN = "root";
    public final String PASSWORD = "1234";

    public Connection getConnect(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public void closeConnect(Connection connection){
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
