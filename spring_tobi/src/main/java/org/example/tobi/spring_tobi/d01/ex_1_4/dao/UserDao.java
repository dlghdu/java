package org.example.tobi.spring_tobi.d01.ex_1_4.dao;

import org.example.tobi.spring_tobi.d01.ex_1_4.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

//    private Connection getConnection() throws SQLException, ClassNotFoundException {
//        String URL = "jdbc:mysql://localhost:3306/spring_tobi";
//        String USER = "root";
//        String PASSWORD = "1234";
//
//        Class.forName("com.mysql.cj.jdbc.Driver"); // forName 빨간 색일 때 alt-enter해서 throws Class... 하기
//        return DriverManager.getConnection(URL, USER, PASSWORD); // getConnection도 빨간 색일 때 위와 동일 SQL로
//    }

//    private simpleConnectionMaker simpleConnectionMaker;
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
//        simpleConnectionMaker = new simpleConnectionMaker();
//        connectionMaker = new DConnectionMaker(); // 구체 클래스
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection conn = connectionMaker.makenewConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        // ; 뒤에서 ctrl+alt+v 하면 뒤에 뭐가 만들어진다.

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        conn.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection conn = connectionMaker.makenewConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }

}
