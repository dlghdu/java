package org.example.tobi.spring_tobi.d03.ex_3_2.dao;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoDeleteAll extends UserDao_v1 {


    public UserDaoDeleteAll(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    PreparedStatement makeStatement(Connection conn) throws SQLException {
        return null;
    }
}
