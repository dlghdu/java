package org.example.tobi.spring_tobi.d01.ex_1_3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class simpleConnectionMaker {

    public Connection makenewConnection() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/spring_tobi";
        String USER = "root";
        String PASSWORD = "1234";

        Class.forName("com.mysql.cj.jdbc.Driver"); // forName 빨간 색일 때 alt-enter해서 throws Class... 하기
        return DriverManager.getConnection(URL, USER, PASSWORD); // getConnection도 빨간 색일 때 위와 동일 SQL로
    }

}
