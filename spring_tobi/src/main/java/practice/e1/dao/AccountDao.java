package practice.e1.dao;

import practice.e1.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    //    private simpleConnectionMaker simpleConnectionMaker;
    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
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
